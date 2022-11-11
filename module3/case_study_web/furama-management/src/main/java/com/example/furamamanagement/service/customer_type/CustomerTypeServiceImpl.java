package com.example.furamamanagement.service.customer_type;

import com.example.furamamanagement.model.CustomerType;
import com.example.furamamanagement.repository.customer_type.CustomerTypeRepositoryImpl;
import com.example.furamamanagement.repository.customer_type.ICustomerTypeRepository;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService{
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> selectAllCustomerTypes() {
        return customerTypeRepository.selectAllCustomerTypes();
    }

    @Override
    public CustomerType getCustomerTypeById(int id) {
        return customerTypeRepository.getCustomerTypeById(id);
    }
}
