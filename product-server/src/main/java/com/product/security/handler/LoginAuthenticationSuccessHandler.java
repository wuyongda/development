package com.product.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.product.login.enums.LoginStatus;
import com.product.model.Result;
import com.product.security.jwt.JwtTokenUtils;
import com.product.util.HttpUtils;

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("username", auth.getPrincipal());
    	//map.put("password", auth.getCredentials());
    	response.setHeader(JwtTokenUtils.TOKEN_NAME, JwtTokenUtils.createToken(map));
        HttpUtils.responseOutWithJson(response, Result.build(LoginStatus.LOGIN, null));
    }
}
