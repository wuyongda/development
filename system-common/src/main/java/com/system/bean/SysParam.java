package com.system.bean;

public class SysParam {
    /**
     * 涓婚敭
     */
    private Long id;

    /**
     * 父级主键
     */
    private Long parentId;

    /**
     * 年度
     */
    private String year;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 参数值
     */
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}