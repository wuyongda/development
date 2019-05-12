package com.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.bean.Area;
import com.customer.dao.IAreaMapper;
import com.customer.service.IAreaService;
import com.product.util.KeyGeneratorUtil;

@Service
public class AreaServiceImpl implements IAreaService{

    @Autowired
    private IAreaMapper areaMapper;
    
    @Override
    public int save(Area area) {
        if (area.getId() == null) {
            area.setId(KeyGeneratorUtil.getNextLong());
            return areaMapper.insert(area);
        }
        return areaMapper.updateByPrimaryKey(area);
    }

	@Override
	public List<Area> findAreas(Area area) {
		return areaMapper.findAreas(area);
	}

}
