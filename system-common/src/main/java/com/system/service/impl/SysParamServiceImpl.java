package com.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.util.KeyGeneratorUtil;
import com.system.bean.SysParam;
import com.system.dao.impl.ISysParamMapper;
import com.system.enums.SysParamEnum;
import com.system.service.ISysParamService;

@Service
public class SysParamServiceImpl implements ISysParamService{

	@Autowired
	private ISysParamMapper sysParamMapper;
	
	@Override
	public Map<String, String> getParamMap(Enum<SysParamEnum> e) {
		return this.getParamMap(e.toString(), this.findCurrentCnq());
	}

	@Override
	public Map<String, String> getParamMap(String name, String cnq) {
		List<SysParam> paramList = sysParamMapper.findParamByParentName(name, cnq);
		
		Map<String, String> map = new HashMap<String, String>(paramList.size());
		for(SysParam param : paramList){
			map.put(param.getName(), param.getValue());
		}
		
		return map;
	}

	@Override
	public List<SysParam> initTree(Long id) {
		SysParam param = new SysParam();
		param.setParentId(id);
		
		return sysParamMapper.initTree(id);
	}

	@Override
	public List<SysParam> findList(SysParam param) {
		return sysParamMapper.findList(param);
	}

	@Override
	public SysParam findById(Long id) {
		return id == null ? null : sysParamMapper.selectByPrimaryKey(id);
	}

	@Override
	public int saveOrUpdate(SysParam param) {
		if(param.getParentId() == null){
			param.setParentId(0l);
		}
		if(param.getId() == null){
			
			param.setId(KeyGeneratorUtil.getNextLong());
			return sysParamMapper.insert(param);
		} else {
			return sysParamMapper.updateByPrimaryKey(param);
		}
	}

	@Override
	public int delete(Long id) {
		return sysParamMapper.deleteByPrimaryKey(id);
	}

	@Override
	public String findCurrentCnq() {
		List<SysParam> paramList = sysParamMapper.findParamByParentName(SysParamEnum.年度.toString(), null);
		return paramList.get(0).getValue();
	}
}
