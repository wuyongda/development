package com.charge.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charge.dto.SfJsDTO;
import com.product.model.Result;

@FeignClient(name="charge")
public interface ChargeAPI {

	/**
	 * 根据热用户主键查询账单信息
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/charge/findSfJsT")
	Result<List<SfJsDTO>> findSfJsT(@RequestParam("customerId") Long customerId);
}
