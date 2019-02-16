package com.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.bean.Customer;
import com.customer.bean.CustomerParam;
import com.customer.dao.ICustomerMapper;
import com.customer.service.ICustomerService;
import com.product.util.KeyGeneratorUtil;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerMapper customerMapper;
    
    @Override
    public Customer findCustomer(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Customer> findCustomers(Customer customer) {
        return customerMapper.findCustomers(customer);
    }

    @Override
    public List<Customer> findCustomersByAuthority(CustomerParam customerParam) {
        return customerMapper.findCustomersByAuthority(customerParam);
    }
    
    @Override
    public int save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(KeyGeneratorUtil.getNextLong());
            return customerMapper.insert(customer);
        }
        return customerMapper.updateByPrimaryKey(customer);
    }
}
