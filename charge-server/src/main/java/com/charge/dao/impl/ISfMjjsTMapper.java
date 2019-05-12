package com.charge.dao.impl;

import org.apache.ibatis.annotations.Mapper;

import com.charge.bean.SfMjjsT;
import com.charge.dao.SfMjjsTMapper;

@Mapper
public interface ISfMjjsTMapper extends SfMjjsTMapper{

	SfMjjsT find(SfMjjsT mjjs);

}