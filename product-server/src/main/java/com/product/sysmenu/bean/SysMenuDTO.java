package com.product.sysmenu.bean;

import java.util.List;

public class SysMenuDTO {
	
    private List<Long> roleIds;
    
    private SysMenu sysMenu;

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}
}