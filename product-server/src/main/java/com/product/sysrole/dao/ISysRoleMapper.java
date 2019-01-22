package com.product.sysrole.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.product.sysrole.bean.SysRole;
import com.product.sysrole.bean.SysRoleMenu;
import com.product.sysrole.bean.SysUserRole;

@Mapper
public interface ISysRoleMapper extends SysRoleMapper{

    List<SysRole> selectList(SysRole sysRole);

	List<SysRole> findSysRolesByUserId(Long id);

	List<SysUserRole> findSysUserRoles(SysUserRole sysUserRole);
	
	void insertSysRoleMenu(SysRoleMenu sysRoleMenu);

	int insertSysUserRole(SysUserRole sysUserRole);

	int deleteSysRoleMenuByRoleId(Long id);
	
	int deleteSysRoleMenuByMenuId(Long id);
	
	int deleteSysUserRoleByUserId(Long id);

}
