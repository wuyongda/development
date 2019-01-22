package com.product.login.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.login.enums.LoginStatus;
import com.product.model.Result;
import com.product.security.util.SecurityUtils;
import com.product.sysuser.bean.SysUser;
import com.product.sysuser.service.ISysUserService;

@RestController
public class LoginController {

    @Autowired 
    private HttpSession session;
    
    @Autowired
    private ISysUserService sysUserService;
    
    /**
     * 系统登录验证
     * @param sysUser
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result<Object> login(SysUser sysUser) {
        // 校验用户名和密码是否为空
        if (StringUtils.isEmpty(sysUser.getUsername())
                || StringUtils.isEmpty(sysUser.getPassword())) {
            return Result.build(LoginStatus.ERROR, null);
        }
        // 校验用户名和密码是否正确
        List<SysUser> sysUerList = sysUserService.findSysUsers(sysUser);
        if (sysUerList.isEmpty()) {
            return Result.build(LoginStatus.ERROR, null);
        }
        session.setAttribute("operator", sysUerList.get(0));
        return Result.success(null);
    }
    
    /**
     * 退出系统
     * @param sysUser
     * @return
     */
    public Result<Object> logout(SysUser sysUser) {
    	session.removeAttribute("operator");
    	return Result.success(null);
    }
    
    @RequestMapping("/login/user")
    public Result<SysUser> user() {
    	return Result.success(SecurityUtils.getLoginUser());
    }
}
