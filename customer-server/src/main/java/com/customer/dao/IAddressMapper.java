package com.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.customer.bean.RoleAddress;

@Mapper
public interface IAddressMapper extends AddressMapper{
    
    void clear();
    
    void synchronization();

    List<RoleAddress> selectRoleAddress(Long roleId);

    List<RoleAddress> selectAddressAuthority(Long roleId);

    int deleteAddressAuthorityByRoleId(Long roleId);

    void saveAddressAuthority(RoleAddress roleAddress);

}