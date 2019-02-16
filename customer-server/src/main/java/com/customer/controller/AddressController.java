package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.AddressAPI;
import com.customer.bean.RoleAddress;
import com.customer.service.IAddressService;
import com.product.model.Result;
import com.product.model.TreeNode;

@RestController
public class AddressController implements AddressAPI{

    @Autowired
    private IAddressService addressService;
    
    @Override
    @Transactional
    public Result<Object> synchronization() {
        // 清空用户区域信息数据
        addressService.clear();
        
        // 清空用户区域信息数据
        addressService.synchronization();
        return Result.success(null);
    }

    @Override
    public Result<List<TreeNode<String>>> addressAuthority(Long roleId) {
        List<TreeNode<String>> address = addressService.addressAuthority(roleId);
        return Result.success(address);
    }

    @Override
    public Result<Object> deleteAddressAuthorityByRoleId(Long roleId) {
        int i = addressService.deleteAddressAuthorityByRoleId(roleId);
        return Result.success(null);
    }

    @Override
    public Result<Object> saveAddressAuthority(@RequestBody RoleAddress roleAddress) {
        int i = addressService.saveAddressAuthority(roleAddress);
        return Result.success(null);
    }

    
    

}
