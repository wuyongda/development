package com.product.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.bean.Customer;
import com.product.model.Result;
import com.wyd.customer.service.FeginDemoService;

@RestController
public class CustomerController {

	@Autowired
	private FeginDemoService demoService;
	
	@RequestMapping("/customer/fegin")
	public Result<Object> fegin(String name) {
		return Result.success(demoService.sayHello(name));
	}
	
	@RequestMapping("/customer/feginByBody")
	public Result<Customer> feginByBody(@RequestBody Customer customer) {
		Customer cus = demoService.feginByBody(customer);
		return Result.success(cus);
	}
}
