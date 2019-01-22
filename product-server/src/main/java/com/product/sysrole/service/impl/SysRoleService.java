package com.product.sysrole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.sysrole.bean.SysRole;
import com.product.sysrole.bean.SysRoleMenu;
import com.product.sysrole.bean.SysUserRole;
import com.product.sysrole.dao.ISysRoleMapper;
import com.product.sysrole.service.ISysRoleService;
import com.product.util.KeyGeneratorUtil;

@Service
public class SysRoleService implements ISysRoleService {

	@Autowired
	private ISysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findSysRoles(SysRole sysRole) {
        return sysRoleMapper.selectList(sysRole);
    }

	@Override
	public List<SysRole> findSysRolesByUserId(Long id) {
		return sysRoleMapper.findSysRolesByUserId(id);
	}

	@Override
	public List<SysUserRole> findSysUserRoles(SysUserRole sysUserRole) {
		return sysRoleMapper.findSysUserRoles(sysUserRole);
	}
	
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
	public void saveMenuAuthority(Long roleId, Long menuId) {
		SysRoleMenu roleMenu = new SysRoleMenu(KeyGeneratorUtil.getNextLong(), roleId, menuId);
		sysRoleMapper.insertSysRoleMenu(roleMenu);
	}

	@Override
	public int saveSysUserRole(Long roleId, Long userId) {
		SysUserRole userRole = new SysUserRole(KeyGeneratorUtil.getNextLong(), roleId, userId);
		return sysRoleMapper.insertSysUserRole(userRole);
	}
	
	@Override
	public int delete(Long id) {
		return sysRoleMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int deleteMenuAuthorityByRoleId(Long id) {
		return sysRoleMapper.deleteSysRoleMenuByRoleId(id);
	}
	
	@Override
	public void deleteMenuAuthorityByMenuId(Long id) {
		sysRoleMapper.deleteSysRoleMenuByMenuId(id);
	}

	@Override
	public int deleteSysUserRole(Long userId) {
		return sysRoleMapper.deleteSysUserRoleByUserId(userId);
	}

}
