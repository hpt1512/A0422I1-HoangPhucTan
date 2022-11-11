package com.example.furamamanagement.service.customer_type;

import com.example.furamamanagement.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> selectAllCustomerTypes();
    CustomerType getCustomerTypeById(int id);
}
