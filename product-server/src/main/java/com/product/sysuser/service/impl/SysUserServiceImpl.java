package com.product.sysuser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.sysuser.bean.SysUser;
import com.product.sysuser.dao.ISysUserMapper;
import com.product.sysuser.service.ISysUserService;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserMapper sysUserMapper;

    @Override
	public int save(SysUser sysUser) {
    	return sysUserMapper.insert(sysUser);
	}
    
    @Override
	public SysUser findSysUser(Integer id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
    
	@Override
	public List<SysUser> findSysUsers(SysUser sysUser) {
		return sysUserMapper.selectList(sysUser);
	}

	

	
}
