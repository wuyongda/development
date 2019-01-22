package com.product.sysmenu.service;

import java.util.List;

import com.product.sysmenu.bean.SysMenu;
import com.product.sysmenu.bean.TreeNode;

public interface ISysMenuService {

	/**
     * 查询所有的导航菜单
     * @param sysMenu 
     * @return
     */
	List<SysMenu> selectSysMenu(SysMenu sysMenu);
	
    /**
     * 以树形结构的形式组装系统导航菜单
     * @param sysMenu
     * @return 
     */
    List<TreeNode<SysMenu>> sysMenuTree(SysMenu sysMenu);

	/**
     * 根据菜单主键获取下一级菜单列表
     * @param id 父级菜单主键
     * @return
     */
    List<SysMenu> menuItems(Long id);
    
	/**
	 * 保存导航菜单
	 * @param sysMenu
	 * @return
	 */
    int save(SysMenu sysMenu);

    /**
     * 分配菜单权限
     * @param roleId  角色主键
     * @return
     */
	List<TreeNode<SysMenu>> menuAuthority(Long roleId);

	/**
	 * 删除菜单信息
	 * @param id 菜单主键
	 * @return
	 */
	int delete(Long id);

}
