package com.product.sysparam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Result;
import com.system.bean.SysParam;
import com.system.service.ISysParamService;

@RestController
public class SysParamController {

	@Autowired
	private ISysParamService sysParamService;
	
	@RequestMapping("/sysParam/initTree")
	public Result<List<SysParam>> initTree(Long id){
		id = id == null?0l:id;
		List<SysParam> paramList = sysParamService.initTree(id);
		return Result.success(paramList);
	}
	
	@RequestMapping("/sysParam/init")
	public Result<Object> init(Long id) {
		// 参数对象
		SysParam param = sysParamService.findById(id);
		
		// 参数类别
		List<SysParam> parentList = sysParamService.initTree(0l);
		
		// 采暖期
		SysParam cnq = new SysParam();
		cnq.setName("采暖期");
		List<SysParam>  yearList = sysParamService.findList(cnq);
		
		// 封装返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("param", param);
		map.put("parent", parentList);
		map.put("year", yearList);
		
		return Result.success(map);
	}
	
	@RequestMapping("/sysParam/findList")
	public Result<List<SysParam>> findList(SysParam param) {
		List<SysParam> paramList = sysParamService.findList(param);
		return Result.success(paramList);
	}
	
	@RequestMapping("/sysParam/save")
	public Result<Long> save(SysParam param) {
		sysParamService.saveOrUpdate(param);
		return Result.success(param.getId());
	}
	
	@RequestMapping("/sysParam/delete")
	public Result<Long> delete(Long id) {
		int i = sysParamService.delete(id);
		return Result.success(id);
	}
}
