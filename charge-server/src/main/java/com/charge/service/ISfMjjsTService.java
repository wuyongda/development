package com.charge.service;

import java.util.List;
import java.util.Map;

import com.customer.bean.Area;
import com.system.enums.SysParamEnum;

public interface ISfMjjsTService {

	/**
	 * 根据面积信息结算账单
	 * @param map 系统参数
	 * @param areaList 面积列表
	 */
	void settlement(Map<Enum<SysParamEnum>, Object> map, List<Area> areaList);

}
