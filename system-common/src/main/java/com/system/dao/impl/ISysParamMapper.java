package com.system.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.system.bean.SysParam;
import com.system.dao.SysParamMapper;

@Mapper
public interface ISysParamMapper extends SysParamMapper{

	List<SysParam> findList(SysParam param);

	List<SysParam> initTree(Long id);

	List<SysParam> findParamByParentName(@Param("name")String name, @Param("cnq")String cnq);

}