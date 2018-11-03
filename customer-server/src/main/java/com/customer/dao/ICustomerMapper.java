package com.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.customer.bean.Customer;

@Mapper
public interface ICustomerMapper extends CustomerMapper{

    /**
     * 保存热用户信息
     * @param customer
     * @return
     */
    Customer save(Customer customer);
    
    /**
     * 查询热用户信息
     * @param customer 热用户实体
     * @return
     */
    List<Customer> findCustomers(Customer customer);

}
