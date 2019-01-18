package com.product.security.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.product.login.enums.LoginStatus;
import com.product.model.Result;
import com.product.security.jwt.JwtTokenUtils;
import com.product.security.model.User;
import com.product.security.util.SecurityUtils;
import com.product.util.HttpUtils;

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
    	
    	User loginUser = (User) auth.getDetails();
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
    	List<String> strList = new ArrayList<String>(authorities.size());
    	
    	for (GrantedAuthority authority : authorities) {
    		strList.add(authority.getAuthority());
		}
    	
    	map.put(SecurityUtils.ID_PARAMETER, loginUser.getId());
    	map.put(SecurityUtils.NAME_PARAMETER, loginUser.getName());
    	map.put(SecurityUtils.USERNAME_PARAMETER, loginUser.getUsername());
    	map.put(SecurityUtils.AUTHORITY_PARAMETER, StringUtils.join(strList.iterator(), ","));
    	
    	response.setHeader(JwtTokenUtils.TOKEN_NAME, JwtTokenUtils.createToken(map));
        HttpUtils.responseOutWithJson(response, Result.build(LoginStatus.LOGIN, null));
    }
}
