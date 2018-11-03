package com.customer.model;

/**
 * 面积信息
 * @author Administrator
 *
 */
public class Area {
	private Long id; // 主键
	
	private Long customerId; // 热用户主键
	
	private String name; // 面积名称
	
	private String jcmj; // 基础面积
	
	private String cg; // 层高
	
	private String cgmj; // 超高面积
	
	private String hjmj; // 合计面积
	
	private String mjlx; // 面积类型

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJcmj() {
		return jcmj;
	}

	public void setJcmj(String jcmj) {
		this.jcmj = jcmj;
	}

	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}

	public String getCgmj() {
		return cgmj;
	}

	public void setCgmj(String cgmj) {
		this.cgmj = cgmj;
	}

	public String getHjmj() {
		return hjmj;
	}

	public void setHjmj(String hjmj) {
		this.hjmj = hjmj;
	}

	public String getMjlx() {
		return mjlx;
	}

	public void setMjlx(String mjlx) {
		this.mjlx = mjlx;
	}
}
