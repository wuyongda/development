package com.product.sysrole.bean;

public class SysRoleMenu {

	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 角色主键
	 */
	private Long roleId;
	
	/**
	 * 菜单主键
	 */
	private Long menuId;

	
	public SysRoleMenu(Long id, Long roleId, Long menuId) {
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
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

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	
}
