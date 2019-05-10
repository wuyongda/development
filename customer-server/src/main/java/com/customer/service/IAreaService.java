package com.customer.service;

import java.util.List;

import com.customer.bean.Area;

public interface IAreaService {

    int save(Area area);

    /**
     * 查询面积信息
     * @param area
     * @return
     */
	List<Area> findAreas(Area area);

}
