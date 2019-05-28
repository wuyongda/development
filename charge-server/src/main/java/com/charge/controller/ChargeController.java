package com.charge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charge.api.ChargeAPI;
import com.charge.dto.SfJsDTO;
import com.charge.service.ISfMjjsTService;
import com.customer.api.AreaAPI;
import com.customer.bean.Area;
import com.product.model.Result;
import com.system.enums.SysParamEnum;
import com.system.service.ISysParamService;

@RestController
public class ChargeController implements ChargeAPI{

	@Autowired
	private AreaAPI areaAPI;
	
	@Autowired
	private ISfMjjsTService sfmjjsTService;
	
	@Autowired
	private ISysParamService sysParamService;
	
	@Override
	public Result<List<SfJsDTO>> findSfJsT(Long customerId) {
		//List<SfMjjsT> mjjsList = sfmjjsTService.findSfmjjs(customerId);
		List<SfJsDTO> list = sfmjjsTService.findSfjsDTO(customerId);
		return Result.success(list);
	}
	
}
