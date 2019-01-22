package com.product.sysuser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.sysuser.bean.SysUser;
import com.product.sysuser.dao.ISysUserMapper;
import com.product.sysuser.service.ISysUserService;
import com.product.util.KeyGeneratorUtil;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserMapper sysUserMapper;

    @Override
	public int save(SysUser sysUser) {
    	if (sysUser.getId() == null) {
    		// 执行新增操作
    		sysUser.setId(KeyGeneratorUtil.getNextLong());
    		return sysUserMapper.insert(sysUser);
		} else {
			// 执行更新操作
			return sysUserMapper.updateByPrimaryKey(sysUser);
		}
	}
    
    @Override
	public SysUser findSysUser(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
    
    @Override
	public SysUser findSysUser(SysUser sysUser) {
    	List<SysUser> list = this.findSysUsers(sysUser);
    	if (list.isEmpty()) {
			return null;
		}
    	return list.get(0);
	}
    
	@Override
	public List<SysUser> findSysUsers(SysUser sysUser) {
		return sysUserMapper.selectList(sysUser);
	}

	@Override
	public int delete(Long id) {
		return sysUserMapper.deleteByPrimaryKey(id);
	}

}
