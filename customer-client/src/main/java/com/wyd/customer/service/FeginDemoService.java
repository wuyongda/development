package com.wyd.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.bean.Customer;

@FeignClient(name="customer")
public interface FeginDemoService {

	@RequestMapping("/customer/sayHello")
	String sayHello(@RequestParam("name") String name);

	@RequestMapping("/customer/feginByBody")
	Customer feginByBody(@RequestBody Customer customer); 
}
