package com.charge.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.model.Result;

@FeignClient(name="charge")
public interface CalculateAPI {

	/**
	 * 根据热用户主键结算账单
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/charge/settlement")
	public Result<String> settlement(@RequestParam("customerId") Long customerId);
}
