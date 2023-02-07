package com.example.furamaspringboot.service.impl;

import com.example.furamaspringboot.model.CustomerType;
import com.example.furamaspringboot.repository.ICustomerTypeRepository;
import com.example.furamaspringboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements IBaseService<CustomerType> {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void insert(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void update(CustomerType customerType) {

    }

    @Override
    public void delete(CustomerType customerType) {

    }

    @Override
    public CustomerType findById(Integer id) {
        return customerTypeRepository.findById(id).orElse(null);
    }
}
