package com.product.charge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charge.api.ChargeAPI;
import com.charge.dto.SfJsDTO;
import com.product.model.Result;

@RestController
public class ChargeController {
 
	@Autowired
	private ChargeAPI chargeAPI;
	
	@RequestMapping("/charge/findSfJsT")
	public Result<List<SfJsDTO>> findSfJsT(Long customerId){
		return chargeAPI.findSfJsT(customerId);
	}
}
