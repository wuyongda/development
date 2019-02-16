package com.customer.bean;

public class Address {
    /**
     * 主键
     */
    private Long id;

    /**
     * 一级-地区等级名称
     */
    private String one;

    /**
     * 二级-地区等级名称
     */
    private String two;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one == null ? null : one.trim();
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two == null ? null : two.trim();
    }
}