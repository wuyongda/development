package com.product.sysmenu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Result;
import com.product.sysmenu.bean.SysMenu;
import com.product.sysmenu.bean.TreeNode;
import com.product.sysmenu.service.ISysMenuService;
import com.product.sysrole.service.ISysRoleService;

@RestController
public class SysMenuController {

    @Autowired
    private ISysMenuService sysMenuService;
    
    @Autowired
    private ISysRoleService sysRoleService;
    
    /**
     * 以树形结构的形式组装系统导航菜单
     * @return
     */
    @ResponseBody
    @RequestMapping("/sysMenu/tree")
    public Result<List<TreeNode<SysMenu>>> sysMenuTree(SysMenu sysMenu) {
        List<TreeNode<SysMenu>> treeNodes = sysMenuService.sysMenuTree(sysMenu);
        
        return Result.success(treeNodes);
    }

    /**
     * 查询所有的导航菜单信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/sysMenu")
    public Result<List<SysMenu>> sysMenu(SysMenu sysMenu) {
        List<SysMenu> sysMenus = sysMenuService.selectSysMenu(sysMenu);
        
        return Result.success(sysMenus);
    }
    
    /**
     * 保存导航菜单信息
     * @param sysMenu
     * @return
     */
    @ResponseBody
    @RequestMapping("/sysMenu/save")
    public Result<Long> save(SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return Result.success(sysMenu.getId());
    }
    
    /**
     * 根据菜单主键获取下一级菜单列表
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/sysMenu/menuItems")
    public Result<List<SysMenu>> menuItems(Long id) {
        List<SysMenu> sysMenus = sysMenuService.menuItems(id);
        return Result.success(sysMenus);
    }
    
    /**
     * 分配菜单权限
     * @return
     */
    @ResponseBody
    @RequestMapping("/sysMenu/menuAuthority")
    public Result<List<TreeNode<SysMenu>>> menuAuthority(Long roleId) {
    	List<TreeNode<SysMenu>> treeNodes = sysMenuService.menuAuthority(roleId);
        
        return Result.success(treeNodes);
    }
    
    /**
     * 删除菜单信息
     * @param id
     * @return
     */
    @Transactional
    @RequestMapping("/sysMenu/delete")
    public Result<Long> delete(Long id) {
    	// 查询子级菜单列表
    	List<SysMenu> chlidrenMenus = sysMenuService.menuItems(id);
    	
    	// 判断是否存在子级菜单列表
    	if (chlidrenMenus.isEmpty()) {
    		// 删除菜单信息
    		sysMenuService.delete(id);
    		// 删除菜单权限
    		sysRoleService.deleteMenuAuthorityByMenuId(id);
    		
    		return Result.success(null);
		}
    	return Result.error("存在子级菜单，禁止删除！", id);
    }
}
