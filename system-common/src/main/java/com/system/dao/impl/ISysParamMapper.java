package com.system.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.system.bean.SysParam;
import com.system.dao.SysParamMapper;

@Mapper
public interface ISysParamMapper extends SysParamMapper{

	List<SysParam> findList(SysParam param);

	List<SysParam> initTree(Long id);

	List<SysParam> findParamByParentName(String name, String cnq);

}