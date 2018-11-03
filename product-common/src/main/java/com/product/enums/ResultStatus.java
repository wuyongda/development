package com.product.enums;

import com.product.interfaces.IResultStatus;

/**
 * 
 * @author Administrator
 *
 */
public enum ResultStatus implements IResultStatus{

	SUCCESS("0000", "成功"),
	ERROR("9999", "失败"),
	;
	
	/**
	 * 状态码
	 */
	private String code;
	
	/**
	 * 提示信息
	 */
	private String msg;

	ResultStatus(String code, String msg) {
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
