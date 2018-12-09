package com.product.sysrole.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.product.sysrole.bean.SysRole;

@Mapper
public interface ISysRoleMapper extends SysRoleMapper{

    List<SysRole> selectList(SysRole sysRole);

}
