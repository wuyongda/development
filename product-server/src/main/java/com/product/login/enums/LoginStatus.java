package com.product.login.enums;

import com.product.interfaces.IResultStatus;

public enum LoginStatus implements IResultStatus{
    ERROR("0001","用户名或密码不正确")
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
