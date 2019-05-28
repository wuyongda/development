package com.charge.dto;

import java.math.BigDecimal;

/**
 * 结算信息DTO
 * @author Administrator
 *
 */
public class SfJsDTO {

	/**
	 * 热用户主键
	 */
	private Long customerId;
	
	/**
	 * 采暖期
	 */
	private String cnq;
	
	/**
	 * 应收金额
	 */
	private BigDecimal ysje;
	
	/**
	 * 收费金额
	 */
	private BigDecimal sfje;
	
	/**
	 * 欠费金额
	 */
	private BigDecimal qfje;
	
	
	public SfJsDTO() {
		super();
	}

	public Long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public String getCnq() {
		return cnq;
	}
	
	public void setCnq(String cnq) {
		this.cnq = cnq;
	}
	
	public BigDecimal getYsje() {
		return ysje;
	}
	
	public void setYsje(BigDecimal ysje) {
		this.ysje = ysje;
	}
	
	public BigDecimal getSfje() {
		return sfje;
	}
	
	public void setSfje(BigDecimal sfje) {
		this.sfje = sfje;
	}
	
	public BigDecimal getQfje() {
		return qfje;
	}
	
	public void setQfje(BigDecimal qfje) {
		this.qfje = qfje;
	}

}
