package com.system.dao;

import java.util.List;

import com.system.bean.SysParam;

public interface SysParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysParam record);

    SysParam selectByPrimaryKey(Long id);

    List<SysParam> selectAll();

    int updateByPrimaryKey(SysParam record);
}