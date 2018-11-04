package com.product.sysmenu.dao;

import com.product.sysmenu.bean.SysMenu;
import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu record);
}