package com.product.sysuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.product.model.Result;
import com.product.sysuser.bean.SysUser;
import com.product.sysuser.service.ISysUserService;

@RestController
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;
    
    @RequestMapping("/sysUser/save")
    public Result<Long> save(SysUser sysUser) {
    	int i = sysUserService.save(sysUser);
        return Result.success(sysUser.getId());
    }

    @RequestMapping("/sysUser/{id}")
    public Result<SysUser> findSysUser(@PathVariable Long id) {
    	SysUser sysUser = sysUserService.findSysUser(id);
    	return Result.success(sysUser);
    }
    
    @RequestMapping("/sysUser")
    public Result<PageInfo<SysUser>> findSysUsers(Page<SysUser> page, SysUser sysUser) {
    	PageHelper.startPage(page.getPageNum(), page.getPageSize());
    	List<SysUser> sysUsers = sysUserService.findSysUsers(sysUser);
    	PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUsers);
    	return Result.success(pageInfo);
    }
}
