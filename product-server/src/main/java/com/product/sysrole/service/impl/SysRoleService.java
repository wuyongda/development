package com.product.sysrole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.sysrole.bean.SysRole;
import com.product.sysrole.dao.ISysRoleMapper;
import com.product.sysrole.service.ISysRoleService;
import com.product.util.KeyGeneratorUtil;

@Service
public class SysRoleService implements ISysRoleService {

	@Autowired
	private ISysRoleMapper sysRoleMapper;

    @Override
    public int save(SysRole sysRole) {
        if (sysRole.getId() == null) {
            sysRole.setId(KeyGeneratorUtil.getNextLong());
            return sysRoleMapper.insert(sysRole);
        } else {
            return sysRoleMapper.updateByPrimaryKey(sysRole);
        }
    }

    @Override
    public List<SysRole> findSysRoles(SysRole sysRole) {
        return sysRoleMapper.selectList(sysRole);
    }
	
}
