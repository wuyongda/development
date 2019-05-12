package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.AreaAPI;
import com.customer.bean.Area;
import com.customer.service.IAreaService;
import com.product.model.Result;

@RestController
public class AreaController implements AreaAPI{

	@Autowired
	private IAreaService areaService;
	
	@Override
	public Result<List<Area>> findArea(@PathVariable Long id){
		// 封装查询参数
		Area area = new Area();
		area.setCustomerId(id);
		// 执行查询操作
		List<Area> areaList = areaService.findAreas(area);
		// 返回数据
		return Result.success(areaList);
	}

	@Override
	public Result<Long> save(@RequestBody Area area) {
		areaService.save(area);
		return Result.success(area.getId());
	}
}
