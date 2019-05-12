package com.system.service;

import java.util.List;
import java.util.Map;

import com.system.bean.SysParam;
import com.system.enums.SysParamEnum;

public interface ISysParamService {

	Map<String, String> getParamMap(Enum<SysParamEnum> e);

	Map<String, String> getParamMap(String name, String cnq);
	
	/**
	 * 
	 * @param id 父级主键
	 * @return
	 */
	List<SysParam> initTree(Long id);

	/**
	 * 查询参数列表
	 * @param param
	 * @return
	 */
	List<SysParam> findList(SysParam param);

	/**
	 * 根据主键查询对象
	 * @param id 主键
	 * @return
	 */
	SysParam findById(Long id);

	/**
	 * 保存对象
	 * @param param 参数对象
	 * @return
	 */
	int saveOrUpdate(SysParam param);

	/**
	 * 根据主键删除对象
	 * @param id 主键
	 * @return
	 */
	int delete(Long id);

	/**
	 * 获取当前采暖期
	 * @return
	 */
	String findCurrentCnq();
}
