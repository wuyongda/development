package com.charge.service;

import java.util.List;
import java.util.Map;

import com.charge.bean.SfMjjsT;
import com.charge.dto.SfJsDTO;
import com.customer.bean.Area;
import com.system.enums.SysParamEnum;

public interface ISfMjjsTService {

	/**
	 * 根据面积信息结算账单
	 * @param map 系统参数
	 * @param areaList 面积列表
	 */
	void settlement(Map<Enum<SysParamEnum>, Object> map, List<Area> areaList);

	/**
	 * 查询面积结算信息
	 * @param customerId 热用户主键
	 * @return
	 */
	List<SfMjjsT> findSfmjjsT(Long customerId);

	List<SfJsDTO> findSfjsDTO(Long customerId);

}
