package com.product.sysmenu.service;

import java.util.List;

import com.product.sysmenu.bean.SysMenu;
import com.product.sysmenu.bean.SysMenuDTO;
import com.product.sysmenu.bean.TreeNode;

public interface ISysMenuService {

    /**
     * 以树形结构的形式组装系统导航菜单
     * @param dto
     * @return 
     */
    List<TreeNode<SysMenu>> sysMenuTree(SysMenuDTO dto);

    /**
     * 查询所有的导航菜单
     * @param sysMenu 
     * @return
     */
	List<SysMenu> selectSysMenu(SysMenu sysMenu);

	/**
	 * 保存导航菜单
	 * @param sysMenu
	 * @return
	 */
    int save(SysMenu sysMenu);

    /**
     * 根据菜单主键获取下一级菜单列表
     * @param id
     * @return
     */
    List<SysMenu> menuItems(Long id);

}
