package com.customer.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.bean.Area;
import com.product.model.Result;

@FeignClient(name="customer")
public interface AreaAPI {

	@RequestMapping("/customer/{id}/area")
	public Result<List<Area>> findArea(@PathVariable("id") Long id);

	@RequestMapping("/customer/area/save")
	public Result<Long> save(Area area);
}
