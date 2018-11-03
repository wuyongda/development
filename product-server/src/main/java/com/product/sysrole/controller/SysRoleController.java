package com.product.sysrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Result;
import com.product.sysrole.bean.SysRole;
import com.product.sysrole.service.ISysRoleService;

@RestController
public class SysRoleController {
	
	@Autowired
	private ISysRoleService sysRoleService;
	
	public Result<Integer> save(SysRole sysRole) {
		return Result.success(sysRole.getId());
		
	}
}
