package com.product.security.jwt;

import io.jsonwebtoken.Claims;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.product.security.model.User;
import com.product.security.util.SecurityUtils;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);  // 提取token
		
		if (StringUtils.isNotBlank(token) && JwtTokenUtils.validateToken(token)) {   //验证token格式是否正确
			Claims claims = JwtTokenUtils.parseToken(token); // 解析token
			
			Long id = Long.valueOf(String.valueOf(claims.get(SecurityUtils.ID_PARAMETER)));
			String name = String.valueOf(claims.get(SecurityUtils.NAME_PARAMETER));
			String principal = String.valueOf(claims.get(SecurityUtils.USERNAME_PARAMETER)); // 登录名
			String authorities = String.valueOf(claims.get(SecurityUtils.AUTHORITY_PARAMETER)); // 角色信息
			
			UsernamePasswordAuthenticationToken toekn = new UsernamePasswordAuthenticationToken(principal, null, getAuthoritie(authorities));
			User loginUser = new User(id, name, principal, null, null);
			toekn.setDetails(loginUser);
			
			SecurityContextHolder.getContext().setAuthentication(toekn);   // 将用户保存到SecurityContext
	    }
		
		filterChain.doFilter(request, response);
	}

	/**
	 * 从请求中提取token
	 * @param request
	 * @return
	 */
	private String getToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(JwtTokenUtils.TOKEN_NAME);
		if (StringUtils.isNotBlank(bearerToken)) {
			return bearerToken; 
		}
		String token = request.getParameter(JwtTokenUtils.TOKEN_NAME);
		return token;
	}
	
	private List<SimpleGrantedAuthority> getAuthoritie(String authoritiesStr) {
		if (StringUtils.isBlank(authoritiesStr)) {
			return null;
		}
		
		String[] strArray = authoritiesStr.split(",");
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>(strArray.length);
		
		for (String str : strArray) {
			authorities.add(new SimpleGrantedAuthority(str));
		}
		
		return authorities;
	}
}
