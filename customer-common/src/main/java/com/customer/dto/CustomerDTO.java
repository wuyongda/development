package com.customer.dto;

import java.util.List;

import com.customer.bean.Area;
import com.customer.bean.Customer;

public class CustomerDTO {

    /**
     * 用户
     */
    private Customer customer;
    
    /**
     * 用户对应的面积列表
     */
    private List<Area> areas;

    
    public CustomerDTO() {
        super();
    }

    public CustomerDTO(Customer customer, List<Area> areas) {
        super();
        this.customer = customer;
        this.areas = areas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Area> getAreas() {
        return areas;
    }

}
