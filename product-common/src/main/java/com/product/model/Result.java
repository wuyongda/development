package com.product.model;

import com.product.enums.ResultStatus;
import com.product.interfaces.IResultStatus;

public class Result<T> {

	/**
	 * 状态码
	 */
	private String code;
	
	/**
	 * 提示信息
	 */
	private String msg;
	
	/**
	 * 返回数据
	 */
	private T data;

	/**
	 * 自定义返回消息
	 * @param status
	 * @param data
	 * @return
	 */
	public static <T> Result<T> build(IResultStatus status,T data){
		Result<T> result = new Result<T>();
		result.setCode(status.getCode());
		result.setMsg(status.getMsg());
		result.setData(data);
		return result;
	}
	
	/**
	 * 默认的成功返回消息
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data){
		return Result.build(ResultStatus.SUCCESS, data);
	}
	
	/**
	 * 默认的失败返回消息
	 * @param status
	 * @param data
	 * @return
	 */
	public static <T> Result<T> error(T data){
		return Result.build(ResultStatus.ERROR, data);
	}
	
	/**
	 * 自定义失败返回消息
	 * @param msg
	 * @param data
	 * @return
	 */
	public static <T> Result<T> error(String msg, T data) {
		Result<T> result = Result.build(ResultStatus.ERROR, data);
		result.setMsg(msg);
		return result;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
