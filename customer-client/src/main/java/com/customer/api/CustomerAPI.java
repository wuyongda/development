package com.customer.api;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.customer.bean.Customer;
import com.customer.bean.CustomerParam;
import com.customer.dto.CustomerDTO;
import com.customer.dto.PageDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.product.model.Result;

@FeignClient(name="customer")
public interface CustomerAPI {

    /**
     * 
     * 查询用户信息
     * @param id 主键
     * @return
     */
    @RequestMapping("/customer/{id}")
    Result<Customer> findCustomer(@PathVariable("id") Long id);
    
    /**
     * 
     * 查询用户信息
     * @param page 分页参数
     * @param customer 用户参数
     * @return
     */
    @RequestMapping("/customer")
    Result<PageInfo<Customer>> findCustomers(@RequestBody PageDTO<Customer, Page<Customer>> pageDto);
    
    @RequestMapping("/customer/authority")
    Result<PageInfo<Customer>> findCustomersByAuthority(@RequestBody PageDTO<CustomerParam, Page<CustomerParam>> pageDto);
    
    /**
     * 
     * 保存用户
     * @param customer 用户参数
     * @return
     */
    @RequestMapping("/customer/save")
    Result<Long> save(Customer customer);
    
    /**
     * 
     * 保存用户
     * @param customerDto 用户参数
     * @return
     */
    @RequestMapping("/customer/new")
    Result<Long> newCustomer(@RequestBody CustomerDTO customerDto);
    
    @RequestMapping("/customer/initTree")
    public Result<List<Map<String, Object>>> initTree(@RequestBody CustomerParam param);

	
}
