package com.example.furamamanagement.repository.customer_type;

import com.example.furamamanagement.model.Customer;
import com.example.furamamanagement.model.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> selectAllCustomerTypes();
    CustomerType getCustomerTypeById(int id);
}
