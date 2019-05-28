package com.product.charge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charge.api.CalculateAPI;
import com.product.model.Result;

@RestController
public class CalculateController {

	@Autowired
	private CalculateAPI calculateAPI;
	
	@RequestMapping("/charge/settlement")
	public Result<String> settlement(Long customerId) {
		return calculateAPI.settlement(customerId);
	}
	
}
