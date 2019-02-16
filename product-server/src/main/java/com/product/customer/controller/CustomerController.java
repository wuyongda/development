package com.product.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.customer.api.AddressAPI;
import com.customer.api.CustomerAPI;
import com.customer.bean.Customer;
import com.customer.bean.CustomerParam;
import com.customer.bean.RoleAddress;
import com.customer.dto.CustomerDTO;
import com.customer.dto.PageDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.product.model.Result;
import com.product.model.TreeNode;
import com.product.security.util.SecurityUtils;
import com.product.sysuser.bean.SysUser;

@RestController
public class CustomerController {

	@Autowired
	private CustomerAPI customerAPI;
	
	@Autowired
	private AddressAPI addressAPI;
	
	@RequestMapping("/customer/{id}")
    public Result<Customer> findCustomer(@PathVariable("id") Long id) {
	    return customerAPI.findCustomer(id);
    }
    
    @RequestMapping("/customer")
    public Result<PageInfo<Customer>> findCustomers(Page<Customer> page, Customer customer) {
        PageDTO<Customer, Page<Customer>> pageDto = new PageDTO<Customer, Page<Customer>>(customer, page);
        return customerAPI.findCustomers(pageDto);
    }
    
    @RequestMapping("/customer/authority")
    public Result<PageInfo<Customer>> findCustomersByAuthority(Page<CustomerParam> page, CustomerParam customerParam) {
        SysUser sysUser = SecurityUtils.getLoginUser();
        customerParam.setUserId(sysUser.getId());
        PageDTO<CustomerParam, Page<CustomerParam>> pageDto = new PageDTO<CustomerParam, Page<CustomerParam>>(customerParam, page);
        return customerAPI.findCustomersByAuthority(pageDto);
    }
    
	@Transactional
	@RequestMapping("/customer/new")
    public Result<Long> newCustomer(@RequestBody CustomerDTO customerDto) {
	    return customerAPI.newCustomer(customerDto);
	}
	
	@RequestMapping("/customer/address/synchronization")
	public Result<Object> synchronization() {
	    return addressAPI.synchronization();
	}
	
	@RequestMapping("/customer/address/addressAuthority")
    public Result<List<TreeNode<String>>> addressAuthority(Long id) {
        return addressAPI.addressAuthority(id);
    }
	
	@RequestMapping("/customer/address/saveAddressAuthority")
    public Result<Object> saveAddressAuthority(@RequestBody JSONObject json) {
        Long roleId = json.getLong("roleId");
        
        // 删除角色原有的数据权限
        addressAPI.deleteAddressAuthorityByRoleId(roleId);
        
        // 保存角色最新的数据权限
        JSONArray authorityArray = json.getJSONArray("authority");
        for(int i = 0; i < authorityArray.size(); i++) {
            @SuppressWarnings("unchecked")
            TreeNode<String> root = authorityArray.getObject(i, TreeNode.class);
            for(TreeNode<String> node : root.getChildren()){
                RoleAddress roleAddress = new RoleAddress();
                roleAddress.setOne(root.getNode());
                roleAddress.setTwo(node.getNode());
                roleAddress.setRoleId(roleId);
                addressAPI.saveAddressAuthority(roleAddress);
            }
        }
        
        return Result.success(null);
    }
}
