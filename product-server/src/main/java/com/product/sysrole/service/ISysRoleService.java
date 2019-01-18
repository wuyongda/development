package com.product.sysrole.service;

import java.util.List;

import com.product.sysrole.bean.SysRole;

public interface ISysRoleService {

    /**
     * 保存角色信息:
     * <br>1.主键为null则执行insert
     * <br>2.主键不为null则执行update
     * @param sysUser
     * @return
     */
    int save(SysRole sysRole);

    List<SysRole> findSysRoles(SysRole sysRole);

	List<SysRole> findSysRolesByUserId(Long id);

	/**
	 * 保存菜单权限
	 * @param roleId
	 * @param menuId
	 */
	void saveMenuAuthority(Long roleId, Long menuId);

	/**
	 * 删除菜单权限
	 * @param roleId
	 */
	int deleteMenuAuthority(Long roleId);
	
}
