package com.product.sysmenu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Result;
import com.product.sysmenu.bean.SysMenu;
import com.product.sysmenu.bean.SysMenuDTO;
import com.product.sysmenu.bean.TreeNode;
import com.product.sysmenu.service.ISysMenuService;
import com.product.sysuser.bean.SysUser;

@RestController
public class SysMenuController {

	@Autowired
	private HttpSession session;
	
    @Autowired
    private ISysMenuService sysMenuService;
    
    /**
     * 以树形结构的形式组装系统导航菜单
     * @return
     */
    @ResponseBody
    @RequestMapping("/sysMenu/tree")
    public Result<List<TreeNode<SysMenu>>> sysMenuTree() {
    	SysUser sysUser = (SysUser) session.getAttribute("operator");
    	SysMenuDTO dto = new SysMenuDTO();
    	//dto.setUserId(sysUser.getId());
        List<TreeNode<SysMenu>> treeNodes = sysMenuService.sysMenuTree(dto);
        
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
}
