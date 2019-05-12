package com.customer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.customer.bean.Customer;
import com.customer.bean.CustomerParam;

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

    /**
     * 查询热用户信息-根据数据权限过滤
     * @param customerParam
     * @return
     */
    List<Customer> findCustomersByAuthority(CustomerParam customerParam);

	List<Map<String, Object>> initTree(CustomerParam param);

}
