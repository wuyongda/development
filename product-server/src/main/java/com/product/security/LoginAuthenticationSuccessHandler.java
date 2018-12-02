package com.product.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.product.login.enums.LoginStatus;
import com.product.model.Result;
import com.product.util.HttpUtils;

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
        HttpUtils.responseOutWithJson(response, Result.build(LoginStatus.LOGIN, null));
    }
}
