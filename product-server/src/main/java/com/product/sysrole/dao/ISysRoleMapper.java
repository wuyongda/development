package com.product.sysrole.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.product.sysrole.bean.SysRole;
import com.product.sysrole.bean.SysRoleMenu;

@Mapper
public interface ISysRoleMapper extends SysRoleMapper{

    List<SysRole> selectList(SysRole sysRole);

	List<SysRole> findSysRolesByUserId(Long id);

	void insertRoleMenu(SysRoleMenu roleMenu);

	int deleteRoleMenuByRoleId(Long roleId);

}
