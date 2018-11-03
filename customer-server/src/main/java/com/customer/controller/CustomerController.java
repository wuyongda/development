package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.bean.Customer;
import com.customer.service.ICustomerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.product.model.Result;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @RequestMapping("/customer/save")
    public Result<Integer> save(Customer customer) {
        // TODO :
        //int i = customerService.save(customer);
        return Result.success(customer.getId());
    }
	@RequestMapping("/customer/{id}")
	public Result<Customer> findCustomer(@PathVariable Integer id) {
	    Customer customer = customerService.findCustomer(id);
		return Result.success(customer);
	}
	
	@RequestMapping("/customer")
	public Result<PageInfo<Customer>> findCustomers(Page<Customer> page, Customer customer) {
	    PageHelper.startPage(1, 1);
	    List<Customer> customers = customerService.findCustomers(customer);
	    PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
	    return Result.success(pageInfo);
	}
}
