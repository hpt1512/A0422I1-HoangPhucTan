package com.example.furamamanagement.repository.customer;

import com.example.furamamanagement.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> selectAllCustomers();
    void insertCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(int id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer getCustomerById(int id);
    List<Customer> findByName(String name);
}
