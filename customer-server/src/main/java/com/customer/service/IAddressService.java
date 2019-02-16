package com.customer.service;

import java.util.List;

import com.customer.bean.RoleAddress;
import com.product.model.TreeNode;

public interface IAddressService {

    /**
     * 清空用户区域信息数据
     */
    void clear();
    
    /**
     * 用户区域信息数据同步
     */
    void synchronization();

    /**
     * 初始化数据权限
     * @return
     */
    List<TreeNode<String>> addressAuthority(Long roleId);

    /**
     * 删除角色对应的数据权限
     * @param roleId 角色主键
     * @return
     */
    int deleteAddressAuthorityByRoleId(Long roleId);

    /**
     * 保存数据权限
     * @param roleAddress
     * @return
     */
    int saveAddressAuthority(RoleAddress roleAddress);

}
