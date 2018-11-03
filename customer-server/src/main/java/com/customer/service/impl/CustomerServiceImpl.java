package com.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.bean.Customer;
import com.customer.dao.ICustomerMapper;
import com.customer.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerMapper customerMapper;
    
    @Override
    public int save(Customer customer) {
        return customerMapper.insert(customer);
    }
    
    @Override
    public Customer findCustomer(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Customer> findCustomers(Customer customer) {
        return customerMapper.findCustomers(customer);
    }
    
}
