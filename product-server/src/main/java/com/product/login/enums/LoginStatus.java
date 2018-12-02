package com.product.login.enums;

import com.product.interfaces.IResultStatus;

public enum LoginStatus implements IResultStatus{
    LOGIN("0000","登录成功"),
    LOGOUT("0001","注销成功"),
    NOT_LOGIN("0002","未登录"),
    ERROR("0002","用户名或密码不正确")
    ;
    private String code;
    private String msg;
    
    LoginStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
