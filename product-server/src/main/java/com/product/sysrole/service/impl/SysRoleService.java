package com.product.sysrole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.sysrole.dao.ISysRoleMapper;
import com.product.sysrole.service.ISysRoleService;

@Service
public class SysRoleService implements ISysRoleService {

	@Autowired
	private ISysRoleMapper sysRoleMapper;
	
}
