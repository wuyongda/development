package com.product.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.product.security.handler.LoginAuthenticationEntryPoint;
import com.product.security.handler.LoginAuthenticationFailureHandler;
import com.product.security.handler.LoginAuthenticationSuccessHandler;
import com.product.security.handler.MyLogoutSuccessHandler;
import com.product.security.jwt.JwtAuthenticationTokenFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 未登录拦截器
    @Autowired
    private LoginAuthenticationEntryPoint authenticationEntryPoint;
    
    // 登录失败拦截器
    @Autowired
    private LoginAuthenticationFailureHandler authenticationFailureHandler;
    
    // 登录成功拦截器
    @Autowired
    private LoginAuthenticationSuccessHandler authenticationSuccessHandler;
    
    // 注销成功拦截器
    @Autowired
    private MyLogoutSuccessHandler logoutSuccessHandler;
    
    // 自定义用户认证拦截器
    @Autowired
    private LoginAuthenticationProvider authenticationProvider;
    
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.authenticationProvider(authenticationProvider); // 添加自定义用户认证拦截器
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .sessionManagement()
        	.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 禁用session
        	.and()
        .authorizeRequests()
        	.antMatchers("/druid/**").permitAll() //阿里监控资源过滤拦截
            .anyRequest().authenticated() // 拦截所有的请求路径
            .and()
        .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint) // 添加未登录拦截器
            .and()
        .formLogin()
            .loginProcessingUrl("/login") // 登录请求路径
            .failureHandler(authenticationFailureHandler) // 添加登录失败拦截器
            .successHandler(authenticationSuccessHandler) // 添加登录成功拦截器
            .and()
        .logout()
            .logoutUrl("/logout") // 注销请求路径
            .logoutSuccessHandler(logoutSuccessHandler) // 添加注销成功拦截器
            .and()
        .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
        .cors() // 设置允许跨域访问
            .and()
        .csrf() 
            .disable(); // 关闭csrf
    }
}
