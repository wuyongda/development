package com.customer.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.bean.Customer;
import com.wyd.customer.service.FeginDemoService;

@RestController
public class FeginDemoServiceImpl implements FeginDemoService{

	@Override
	public String sayHello(String name) {
		String str = "Hello " + name;
		System.err.println(str);
		return str;
	}

	@Override
	public Customer feginByBody(Customer customer) {
		System.err.println("创建新的customer对象:" + customer.getName());
		Customer cus = new Customer();
		return cus;
	}

}
