package com.product.sysmenu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.product.sysmenu.bean.SysMenu;
import com.product.sysmenu.bean.SysMenuDTO;

@Mapper
public interface ISysMenuMapper extends SysMenuMapper{

    List<SysMenu> selectList(SysMenuDTO dto);

    List<SysMenu> menuItems(Long id);

}