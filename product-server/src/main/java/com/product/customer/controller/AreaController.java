package com.product.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.customer.api.AreaAPI;
import com.customer.bean.Area;
import com.product.model.Result;

@RestController
public class AreaController {

	@Autowired
	private AreaAPI areaAPI;
	
	@RequestMapping("/customer/{id}/area")
	public Result<List<Area>> findArea(@PathVariable("id") Long id){
		return areaAPI.findArea(id);
	}
	
	@RequestMapping("/customer/area/save")
	public Result<Long> save(Area area){
		return areaAPI.save(area);
	}
	
	@RequestMapping("/customer/area/init")
	public Result<Object> init(){
		JSONObject initData = new JSONObject();
		JSONObject json = null;
		
		JSONArray mjlb = new JSONArray();
		json = new JSONObject();
		json.put("value", "住宅");
		mjlb.add(json);
		
		json = new JSONObject();
		json.put("value", "办公");
		mjlb.add(json);
		initData.put("mjlb", mjlb);
		
		JSONArray djlb = new JSONArray();
		json = new JSONObject();
		json.put("value", "居民单价");
		djlb.add(json);
		
		json = new JSONObject();
		json.put("value", "非居民单价");
		djlb.add(json);
		initData.put("djlb", djlb);
		
		return Result.success(initData);
	}
}
