package com.customer.dao;

import com.customer.bean.Address;
import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Address record);

    Address selectByPrimaryKey(Long id);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);
}