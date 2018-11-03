package com.product.sysuser.service;

import java.util.List;

import com.product.sysuser.bean.SysUser;

public interface ISysUserService {

	int save(SysUser sysUser);

	SysUser findSysUser(Integer id);

	List<SysUser> findSysUsers(SysUser sysUser);
}
