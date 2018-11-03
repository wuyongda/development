package com.customer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Area;
import com.github.pagehelper.Page;
import com.product.model.Result;

@RestController
public class AreaController {

	@RequestMapping("/customer/{id}/area")
	public Result<Page<Area>> findArea(@PathVariable Long id){
		return Result.success(null);
	}
}
