package com.example.furamamanagement.service.customer;

import com.example.furamamanagement.model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> selectAllCustomers();
    Map<String, String> insertCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(int id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer getCustomerById(int id);
    List<Customer> findByName(String name);
}
