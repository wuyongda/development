package com.product.security;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.product.sysuser.bean.SysUser;
import com.product.sysuser.service.ISysUserService;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private ISysUserService userService;
    
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
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        List<SysUser> sysUsers = userService.findSysUsers(sysUser);
        
        // 检验逻辑判断
        if (sysUsers.isEmpty()) {
            // 未通过登录校验
            return null;
        } else {
            // 通过登录校验
            return authentication;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 设置是否开启登录校验
        // true: 开启登录验证  
        // false: 关闭登录验证
        return true;
    }
}
