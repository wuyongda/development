package com.charge.dao;

import com.charge.bean.SfMjjsT;
import java.util.List;

public interface SfMjjsTMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SfMjjsT record);

    SfMjjsT selectByPrimaryKey(Long id);

    List<SfMjjsT> selectAll();

    int updateByPrimaryKey(SfMjjsT record);
}