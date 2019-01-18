package com.product.security.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.product.security.model.User;
import com.product.sysuser.bean.SysUser;

public class SecurityUtils {

	public final static String ID_PARAMETER = "id";
	
	public final static String NAME_PARAMETER = "name";
	
	public final static String USERNAME_PARAMETER = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;
	
	public final static String AUTHORITY_PARAMETER = "authorities";
	
	/**
	 * 获取当前系统登录人
	 * @return
	 */
	public static SysUser getLoginUser() {
		// 从security上下文中获取当前系统登录人的信息
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		User userDetails = (User) authentication.getDetails();
		
		// security的登录信息实体转换成系统用户实体对象
		SysUser loginUser = new SysUser();
		
		loginUser.setId(userDetails.getId());
		loginUser.setRealName(userDetails.getName());
		loginUser.setUsername(userDetails.getUsername());
		
		return loginUser;
	}
	
	/**
	 * 获取当前系统登录人的角色信息
	 * @return
	 */
	public static List<Long> getLoginUserRole() {
		// 从security上下文中获取当前系统登录人的信息
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 从登录人信息中提取角色信息
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		// security的角色信息实体转换成系统角色实体对象
		List<Long> roleIds = new ArrayList<Long>(authorities.size());
		
		for (GrantedAuthority authority : authorities) {
			roleIds.add(Long.valueOf(authority.getAuthority()));
		}
		
		return roleIds;
	}
}
