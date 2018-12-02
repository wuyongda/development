package com.product.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.product.login.enums.LoginStatus;
import com.product.model.Result;
import com.product.util.HttpUtils;

@Component
public class LoginAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        HttpUtils.responseOutWithJson(response, Result.build(LoginStatus.NOT_LOGIN, null));
    }
}
