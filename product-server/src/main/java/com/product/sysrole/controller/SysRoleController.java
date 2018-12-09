package com.product.sysrole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.product.model.Result;
import com.product.sysrole.bean.SysRole;
import com.product.sysrole.service.ISysRoleService;

@RestController
public class SysRoleController {
	
	@Autowired
	private ISysRoleService sysRoleService;
	
	@RequestMapping("/sysRole/save")
	public Result<Long> save(SysRole sysRole) {
	    int i = sysRoleService.save(sysRole);
		return Result.success(sysRole.getId());
		
	}
	
	@RequestMapping("/sysRole")
    public Result<PageInfo<SysRole>> findSysRoles(Page<SysRole> page, SysRole sysRole) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysRole> sysRoles = sysRoleService.findSysRoles(sysRole);
        PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(sysRoles);
        return Result.success(pageInfo);
    }
}
