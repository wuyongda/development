package com.product.sysmenu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.product.sysmenu.bean.SysMenu;

@Mapper
public interface ISysMenuMapper extends SysMenuMapper{

    List<SysMenu> selectList(SysMenu sysMenu);

    List<SysMenu> menuItems(Long id);

	List<Long> selectRoleMenu(List<Long> loginUserRole);

}