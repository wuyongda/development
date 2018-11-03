package com.product.sysmenu.bean;

public class SysMenuDTO {
	
    private Integer userId;
    
    private SysMenu sysMenu;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}
}