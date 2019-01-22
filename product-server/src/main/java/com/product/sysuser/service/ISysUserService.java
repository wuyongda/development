package com.product.sysuser.service;

import java.util.List;

import com.product.sysuser.bean.SysUser;

public interface ISysUserService {

	SysUser findSysUser(Long id);

	SysUser findSysUser(SysUser sysUser);
	
	List<SysUser> findSysUsers(SysUser sysUser);

	/**
	 * 保存用户信息:
	 * <br>1.主键为null则执行insert
	 * <br>2.主键不为null则执行update
	 * @param sysUser
	 * @return
	 */
	int save(SysUser sysUser);
	
	/**
	 * 删除用户信息
	 * @param id 用户主键
	 * @return
	 */
	int delete(Long id);
}
