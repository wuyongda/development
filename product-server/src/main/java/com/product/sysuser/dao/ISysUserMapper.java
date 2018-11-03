package com.product.sysuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.product.sysuser.bean.SysUser;

@Mapper
public interface ISysUserMapper extends SysUserMapper{

    List<SysUser> selectList(SysUser sysUser);

}
