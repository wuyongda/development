package com.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.CustomerAPI;
import com.customer.bean.Area;
import com.customer.bean.Customer;
import com.customer.bean.CustomerParam;
import com.customer.dto.CustomerDTO;
import com.customer.dto.PageDTO;
import com.customer.service.IAreaService;
import com.customer.service.ICustomerService;
import com.customer.util.PageHelperUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.product.model.Result;

@RestController
public class CustomerController implements CustomerAPI{

    @Autowired
    private ICustomerService customerService;
    
    @Autowired
    private IAreaService areaService;
    
    @Override
    public Result<Customer> findCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findCustomer(id);
        return Result.success(customer);
    }
    
    @Override
    public Result<PageInfo<Customer>> findCustomers(@RequestBody PageDTO<Customer, Page<Customer>> pageDto) {
        PageHelperUtils.startPage(pageDto.getPage());
        List<Customer> customers = customerService.findCustomers(pageDto.getModel());
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
        return Result.success(pageInfo);
    }
    
    @Override
    public Result<PageInfo<Customer>> findCustomersByAuthority(@RequestBody PageDTO<CustomerParam, Page<CustomerParam>> pageDto) {
        PageHelperUtils.startPage(pageDto.getPage());
        List<Customer> customers = customerService.findCustomersByAuthority(pageDto.getModel());
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
        return Result.success(pageInfo);
    }
    
    @Override
    @Transactional
    public Result<Long> newCustomer(@RequestBody CustomerDTO customerDto) {
        // 保存用户
        Customer customer = customerDto.getCustomer();
        customerService.save(customer);
        
        // 保存面积
        for(Area area : customerDto.getAreas()) {
            area.setCustomerId(customer.getId());
            areaService.save(area);
        }
        
        return Result.success(customer.getId());
    }

    @Override
    public Result<List<Map<String, Object>>> initTree(@RequestBody CustomerParam param) {
    	List<Map<String, Object>> listNode = customerService.initTree(param);
    	return Result.success(listNode);
    }
}
