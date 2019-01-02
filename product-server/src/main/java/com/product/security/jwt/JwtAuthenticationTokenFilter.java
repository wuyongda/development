package com.product.security.jwt;

import io.jsonwebtoken.Claims;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{

	private String usernameParameter = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);  // 提取token
		
		if (StringUtils.isNotBlank(token) && JwtTokenUtils.validateToken(token)) {   //验证token格式是否正确
			Claims claims = JwtTokenUtils.parseToken(token); // 解析token
			String principal = String.valueOf(claims.get(usernameParameter)); // 登录名
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, null);
		    SecurityContextHolder.getContext().setAuthentication(authentication);   // 将用户保存到SecurityContext
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

}
