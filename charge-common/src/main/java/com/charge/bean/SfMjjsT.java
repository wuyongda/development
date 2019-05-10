package com.charge.bean;

import java.math.BigDecimal;

public class SfMjjsT {
    /**
     * 主键
     */
    private Long id;

    /**
     * 热用户主键
     */
    private Long customerId;

    /**
     * 面积主键
     */
    private Long areaId;

    /**
     * 采暖期
     */
    private String cnq;

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

    /**
     * 面积类别
     */
    private String mjlb;

    /**
     * 单价类别
     */
    private String djlb;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 应收金额
     */
    private BigDecimal ysje;

    /**
     * 收费金额
     */
    private BigDecimal sfje;

    /**
     * 欠费金额
     */
    private BigDecimal qfje;

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

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getCnq() {
        return cnq;
    }

    public void setCnq(String cnq) {
        this.cnq = cnq == null ? null : cnq.trim();
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

    public String getMjlb() {
        return mjlb;
    }

    public void setMjlb(String mjlb) {
        this.mjlb = mjlb == null ? null : mjlb.trim();
    }

    public String getDjlb() {
        return djlb;
    }

    public void setDjlb(String djlb) {
        this.djlb = djlb == null ? null : djlb.trim();
    }

    public BigDecimal getDj() {
        return dj;
    }

    public void setDj(BigDecimal dj) {
        this.dj = dj;
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