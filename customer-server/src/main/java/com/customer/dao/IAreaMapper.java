package com.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.customer.bean.Area;

@Mapper
public interface IAreaMapper extends AreaMapper{

	List<Area> findAreas(Area area);
	
}
