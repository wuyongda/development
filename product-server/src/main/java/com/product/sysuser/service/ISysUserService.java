package com.product.sysuser.service;

import java.util.List;

import com.product.sysuser.bean.SysUser;

public interface ISysUserService {

	/**
	 * 保存用户信息:
	 * <br>1.主键为null则执行insert
	 * <br>2.主键不为null则执行update
	 * @param sysUser
	 * @return
	 */
	int save(SysUser sysUser);

	SysUser findSysUser(Long id);

	List<SysUser> findSysUsers(SysUser sysUser);
}
