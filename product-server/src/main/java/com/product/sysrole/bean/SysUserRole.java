package com.product.sysrole.bean;

public class SysUserRole {

	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 角色主键
	 */
	private Long roleId;
	
	/**
	 * 用户主键
	 */
	private Long userId;

	
	public SysUserRole(Long id, Long roleId, Long userId) {
		this.id = id;
		this.roleId = roleId;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
