package com.product.security.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.product.sysrole.bean.SysRole;
import com.product.sysrole.service.ISysRoleService;
import com.product.sysuser.bean.SysUser;
import com.product.sysuser.service.ISysUserService;

@Service
public class UserService implements UserDetailsService{

	@Autowired
    private ISysUserService userService;
	
	@Autowired
    private ISysRoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 根据登录名称查询登录用户的信息
		SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser = userService.findSysUser(sysUser);
        if (sysUser == null) {
			return null;
		}
        
        return  new User(sysUser.getId(), sysUser.getRealName(), sysUser.getUsername(), sysUser.getPassword(), null);
	}

	public List<SimpleGrantedAuthority> getAuthorities(UserDetails userDetails) {
		Assert.isInstanceOf(User.class, userDetails);
		
		User user = (User) userDetails;
		List<SysRole> sysRoles = roleService.findSysRolesByUserId(user.getId());
        
        List<SimpleGrantedAuthority> authoritys = new ArrayList<SimpleGrantedAuthority>(sysRoles.size());
        
        for (SysRole sysRole : sysRoles) {
        	authoritys.add(new SimpleGrantedAuthority(sysRole.getId().toString()));
		}
        
        return authoritys;
	}

}
