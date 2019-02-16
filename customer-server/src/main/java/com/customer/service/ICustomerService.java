package com.customer.service;

import java.util.List;

import com.customer.bean.Customer;
import com.customer.bean.CustomerParam;

public interface ICustomerService {

    /**
     * 保存用户信息
     * @param customer 热用户模型
     * @return
     */
    int save(Customer customer);
    
    /**
     * 查询热用户信息
     * @param id 热用户主键
     * @return
     */
    Customer findCustomer(Long id);

    /**
     * 查询热用户信息
     * @param customer 热用户模型
     * @return
     */
    List<Customer> findCustomers(Customer customer);

    /**
     * 查询热用户信息-经过数据权限过滤
     * @param model
     * @return
     */
    List<Customer> findCustomersByAuthority(CustomerParam customerParam);

}
