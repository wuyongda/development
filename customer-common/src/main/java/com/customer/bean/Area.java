package com.customer.bean;

import java.math.BigDecimal;

public class Area {
    /**
     * 主键
     */
    private Long id;

    /**
     * 面积名称
     */
    private String name;

    /**
     * 收费面积
     */
    private BigDecimal sfmj;

    /**
     * 占地面积
     */
    private BigDecimal zdmj;

    /**
     * 层高
     */
    private BigDecimal cg;

    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getSfmj() {
        return sfmj;
    }

    public void setSfmj(BigDecimal sfmj) {
        this.sfmj = sfmj;
    }

    public BigDecimal getZdmj() {
        return zdmj;
    }

    public void setZdmj(BigDecimal zdmj) {
        this.zdmj = zdmj;
    }

    public BigDecimal getCg() {
        return cg;
    }

    public void setCg(BigDecimal cg) {
        this.cg = cg;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}