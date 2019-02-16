package com.customer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.customer.bean.RoleAddress;
import com.customer.dao.IAddressMapper;
import com.customer.service.IAddressService;
import com.product.model.TreeNode;
import com.product.util.KeyGeneratorUtil;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressMapper addressMapper;
    
    @Override
    public void clear() {
        addressMapper.clear();
    }
    
    @Override
    public void synchronization() {
        addressMapper.synchronization();
    }

    @Override
    public List<TreeNode<String>> addressAuthority(Long roleId) {
        // 查询区域信息数据权限
        List<RoleAddress> addressList = addressMapper.selectAddressAuthority(roleId);
        
        // 数据权限过滤
        JSONObject root= this.addressAuthorityFilter(roleId, addressList);
        
        // 组装树形结构结果集
        return this.dataStructureConversionFilter(root);
    }

    private JSONObject addressAuthorityFilter(Long roleId, List<RoleAddress> roleAddressList) {
        JSONObject root = new JSONObject();
        JSONObject children = null; 
        JSONObject one = null;
        JSONObject two = null;
        boolean checked;
        for(RoleAddress roleAddress : roleAddressList) {
            one = root.getJSONObject(roleAddress.getOne());
            if (one == null) {
                one = new JSONObject();
                //one.put("checked", Boolean.TRUE);
                one.put("children", new JSONObject());
                root.put(roleAddress.getOne(), one);
            }
            
            two = new JSONObject();
            children = one.getJSONObject("children");
            children.put(roleAddress.getTwo(), two);
            
            checked = roleAddress.getRoleId() != null;
            if (checked) {
                one.put("checked", checked);
                two.put("checked", checked);
            }
        }
        
        return root;
    }

    private List<TreeNode<String>> dataStructureConversionFilter(JSONObject root) {
        if (root == null) {
            return null;
        }
        
        Set<Entry<String, Object>> entrySet = root.entrySet();
        List<TreeNode<String>> parentList = new ArrayList<>(entrySet.size());
        JSONObject obj = null;
        for(Entry<String, Object> entry: entrySet){
            obj = (JSONObject) entry.getValue();
            TreeNode<String> node = new TreeNode<>();
            node.setNode(entry.getKey());
            node.setChecked(obj.getBooleanValue("checked"));
            List<TreeNode<String>> childrenList = this.dataStructureConversionFilter(obj.getJSONObject("children"));
            node.setChildren(childrenList);
            parentList.add(node);
        }
        return parentList;
    }

    @Override
    public int deleteAddressAuthorityByRoleId(Long roleId) {
        return addressMapper.deleteAddressAuthorityByRoleId(roleId);
    }

    @Override
    public int saveAddressAuthority(RoleAddress roleAddress) {
        if (roleAddress.getId() == null) {
            roleAddress.setId(KeyGeneratorUtil.getNextLong());
            addressMapper.saveAddressAuthority(roleAddress);
        }
        return 0;
    }

}
