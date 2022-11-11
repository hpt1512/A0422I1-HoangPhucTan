package com.example.furamamanagement.service.customer;

import com.example.furamamanagement.model.Customer;
import com.example.furamamanagement.repository.customer.CustomerRepositoryImpl;
import com.example.furamamanagement.repository.customer.ICustomerRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }
}
