package com.customer.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.bean.RoleAddress;
import com.product.model.Result;
import com.product.model.TreeNode;

@FeignClient(name="customer")
public interface AddressAPI {

    /**
     * 用户区域信息数据同步
     * @return
     */
    @RequestMapping("/customer/address/synchronization")
    Result<Object> synchronization();

    /**
     * 初始化数据权限
     * @return
     */
    @RequestMapping("/customer/address/addressAuthority")
    Result<List<TreeNode<String>>> addressAuthority(@RequestParam("roleId") Long roleId);

    @RequestMapping("/customer/address/deleteAddressAuthority")
    Result<Object> deleteAddressAuthorityByRoleId(@RequestParam("roleId") Long roleId);

    @RequestMapping("/customer/address/saveAddressAuthority")
    Result<Object> saveAddressAuthority(@RequestBody RoleAddress roleAddress);
}
