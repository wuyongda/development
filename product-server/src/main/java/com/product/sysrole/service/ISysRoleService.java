package com.product.sysrole.service;

import java.util.List;

import com.product.sysrole.bean.SysRole;
import com.product.sysrole.bean.SysUserRole;

public interface ISysRoleService {

    List<SysRole> findSysRoles(SysRole sysRole);

	List<SysRole> findSysRolesByUserId(Long id);

	/**
	 * 查询用户角色关联信息
	 * @param sysUserRole
	 * @return
	 */
	List<SysUserRole> findSysUserRoles(SysUserRole sysUserRole);
	
	/**
     * 保存角色信息:
     * <br>1.主键为null则执行insert
     * <br>2.主键不为null则执行update
     * @param sysUser
     * @return
     */
    int save(SysRole sysRole);
    
	/**
	 * 保存菜单权限
	 * @param roleId 角色主键
	 * @param menuId 菜单主键
	 */
	void saveMenuAuthority(Long roleId, Long menuId);

	/**
	 * 保存用户角色关联信息
	 * @param roleId 角色主键
	 * @param userId 用户主键
	 * @return
	 */
	int saveSysUserRole(Long roleId, Long userId);
	
	/**
	 * 删除角色信息
	 * @param id 角色主键
	 * @return
	 */
	int delete(Long id);
	
	/**
	 * 删除菜单权限
	 * @param roleId 角色主键
	 */
	int deleteMenuAuthorityByRoleId(Long id);

	/**
	 * 删除菜单权限
	 * @param id 菜单主键
	 */
	void deleteMenuAuthorityByMenuId(Long id);
	
	/**
	 * 删除用户角色关联信息
	 * @param userId 用户主键
	 * @return
	 */
	int deleteSysUserRole(Long userId);

}
