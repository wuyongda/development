package com.product.security;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.product.security.model.UserService;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private UserService userDetailService;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	// 获取用户名
        String username = (String) authentication.getPrincipal();
        // 获取密码
        String password = (String) authentication.getCredentials();
        
        if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
        	// 登录表单为空时，从token中获取用户信息
        	Authentication token = SecurityContextHolder.getContext().getAuthentication();
        	if (token!= null) {
        		// 足够如果登录表单为空，且token中存在登录信息时，直接返回token中的登录信息
				return token;
			}
        }
        
        // 数据库用户信息校验
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        
        // 判断登录用户输入的密码是否与数据库中的一致
        if (userDetails.getPassword().equals(password)) {
        	// 通过登录校验
        	
        	// 获取登录用户的权限信息
        	List<SimpleGrantedAuthority> authorities = userDetailService.getAuthorities(userDetails);
        	
        	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, authorities);
        	token.setDetails(userDetails);
        	return token;
		}
        
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 设置是否开启登录校验
        // true: 开启登录验证  
        // false: 关闭登录验证
        return true;
    }
}
