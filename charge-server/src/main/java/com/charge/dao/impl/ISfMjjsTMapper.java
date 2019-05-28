package com.charge.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.charge.bean.SfMjjsT;
import com.charge.dao.SfMjjsTMapper;
import com.charge.dto.SfJsDTO;

@Mapper
public interface ISfMjjsTMapper extends SfMjjsTMapper{

	SfMjjsT find(SfMjjsT mjjs);

	List<SfJsDTO> findSfjsDTO(SfMjjsT mjjs);

}