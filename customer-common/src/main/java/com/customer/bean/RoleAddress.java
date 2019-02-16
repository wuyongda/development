package com.customer.bean;

public class RoleAddress {

    private Long id;
    
    private Long roleId;
    
    private String one;
    
    private String two;

    public Long getId() {
        return id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public void setTwo(String two) {
        this.two = two;
    }
    
}
