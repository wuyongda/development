package com.charge.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charge.bean.SfMjjsT;
import com.charge.dao.impl.ISfMjjsTMapper;
import com.charge.dto.SfJsDTO;
import com.charge.service.ISfMjjsTService;
import com.customer.bean.Area;
import com.product.util.KeyGeneratorUtil;
import com.system.enums.SysParamEnum;

@Service
public class SfMjjsTServiceImpl implements ISfMjjsTService{

	@Autowired
	private ISfMjjsTMapper sfMjjsTMapper;
	
	/**
	 * 结算
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void settlement(Map<Enum<SysParamEnum>, Object> map, List<Area> areaList) {
		SfMjjsT mjjs = null;
		String dqcnq = (String) map.get(SysParamEnum.年度);
		Map<String, String> djlb = (Map<String, String>) map.get(SysParamEnum.单价类别);
		
		for(Area area : areaList){
			validate(area);
			mjjs = new SfMjjsT();
			mjjs.setCnq(dqcnq);
			mjjs.setAreaId(area.getId());
			mjjs = sfMjjsTMapper.find(mjjs);
			if(mjjs == null){
				// 面积结算不存在，则新增
				mjjs = new SfMjjsT();
				mjjs.setId(KeyGeneratorUtil.getNextLong());
				mjjs.setAreaId(area.getId());
				mjjs.setCustomerId(area.getCustomerId());
				mjjs.setCnq(dqcnq);
				mjjs.setSfje(BigDecimal.ZERO);
				this.updateMjjs(area, mjjs, djlb);
				
				// 平账公式
				this.calculate(mjjs);
				
				// 存档
				sfMjjsTMapper.insert(mjjs);
			} else {
				// 面积结算已存在，则修改
				this.updateMjjs(area, mjjs, djlb);
				
				// 平账公式
				this.calculate(mjjs);
				
				// 存档
				sfMjjsTMapper.updateByPrimaryKey(mjjs);
			}
		}
	}

	private void validate(Area area) {
		if(area.getDjlb() == null) {
			throw new RuntimeException("未分配面积类别");
		}
	}

	/**
	 * 更新面积结算信息
	 * @param area 面积
	 * @param mjjs 面积结算
	 * @param map 参数列表
	 */
	private void updateMjjs(Area area, SfMjjsT mjjs, Map<String, String> map) {
		mjjs.setName(area.getName());
		mjjs.setSfmj(area.getSfmj());
		mjjs.setZdmj(area.getZdmj());
		mjjs.setCg(area.getCg());
		mjjs.setMjlb(area.getMjlb());
		mjjs.setDjlb(area.getDjlb());
		mjjs.setDj(new BigDecimal(map.get(mjjs.getDjlb())));
		mjjs.setYsje(mjjs.getSfmj().multiply(mjjs.getDj()).setScale(2));
	}

	/**
	 * 面积结算平账公式
	 * @param mjjs 面积结算信息
	 */
	private void calculate(SfMjjsT mjjs) {
		// 公式： 应收 - 实收 = 欠费
		BigDecimal ysje = mjjs.getYsje(); // 应收金额
		BigDecimal sfje = mjjs.getSfje(); // 实收金额
		BigDecimal qfje = null; // 欠费金额
		
		// 计算欠费金额
		qfje = ysje.subtract(sfje).setScale(2);
		
		// 将欠费结果保存到面积结算上
		mjjs.setQfje(qfje);
	}

	@Override
	public List<SfMjjsT> findSfmjjsT(Long customerId) {
		return this.findSfmjjs(customerId, null);
	}
	
	private List<SfMjjsT> findSfmjjs(Long customerId, String cnq) {
		SfMjjsT mjjs = new SfMjjsT();
		mjjs.setCustomerId(customerId);
		mjjs.setCnq(cnq);
		return this.findSfmjjs(mjjs);
	}

	private List<SfMjjsT> findSfmjjs(SfMjjsT mjjs) {
		return null;
	}

	@Override
	public List<SfJsDTO> findSfjsDTO(Long customerId) {
		return this.findSfjsDTO(customerId, null);
	}

	private List<SfJsDTO> findSfjsDTO(Long customerId, String cnq) {
		SfMjjsT mjjs = new SfMjjsT();
		mjjs.setCustomerId(customerId);
		mjjs.setCnq(cnq);
		return this.findSfjsDTO(mjjs);
	}

	private List<SfJsDTO> findSfjsDTO(SfMjjsT mjjs) {
		return sfMjjsTMapper.findSfjsDTO(mjjs);
	}

}
