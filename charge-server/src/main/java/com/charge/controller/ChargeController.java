package com.charge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charge.api.ChargeAPI;
import com.charge.dao.SfMjjsTMapper;
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
	private SfMjjsTMapper SfMjjsTMapper;
	
	@Autowired
	private ISysParamService sysParamService;
	
	/**
	 * 用户结算
	 * @return
	 */
	@RequestMapping("/charge/settlement")
	public Result<String> settlement(Long customerId) {
		Map<Enum<SysParamEnum>, Object> param = new HashMap<Enum<SysParamEnum>, Object>();
		// 获取系统参数
		Map<String, String> djlb = sysParamService.getParamMap(SysParamEnum.单价类别);
		param.put(SysParamEnum.单价类别, djlb);
		
		String dqcnq = sysParamService.findCurrentCnq();
		param.put(SysParamEnum.年度, dqcnq);
		
		
		// 获取结算的面积
		Result<List<Area>> result = areaAPI.findArea(customerId);
		List<Area> areaList= result.getData();
		
		// 执行结算
		sfmjjsTService.settlement(param, areaList);
		
		return Result.success(null);
	}
}
