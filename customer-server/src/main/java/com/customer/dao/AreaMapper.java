package com.customer.dao;

import com.customer.bean.Area;
import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Area record);

    Area selectByPrimaryKey(Long id);

    List<Area> selectAll();

    int updateByPrimaryKey(Area record);
}