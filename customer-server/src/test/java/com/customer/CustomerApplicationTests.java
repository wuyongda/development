package com.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.customer.bean.RoleAddress;
import com.customer.dao.IAddressMapper;
import com.customer.service.IAddressService;
import com.product.model.TreeNode;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
public class CustomerApplicationTests {

    @Autowired
    private IAddressService addressService;
    
	@Test
	public void contextLoads() {
	}

	@Test
	public void testService() {
	    List list = addressService.addressAuthority(1l);
	    System.out.println(new JSONArray(list).toJSONString());
    }

	
}
