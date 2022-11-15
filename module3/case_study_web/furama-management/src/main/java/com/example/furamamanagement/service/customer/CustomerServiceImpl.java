package com.example.furamamanagement.service.customer;

import com.example.furamamanagement.model.Customer;
import com.example.furamamanagement.repository.customer.CustomerRepositoryImpl;
import com.example.furamamanagement.repository.customer.ICustomerRepository;
import com.example.furamamanagement.validate.Validation;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService{
    ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public Map<String, String> insertCustomer(Customer customer) throws SQLException {
        // Validate
        Map<String, String> errorMap = new HashMap<>();
        if ("".equals(customer.getEmail())){
            errorMap.put("email","Email không được để trống");
        }else if(!Validation.checkEmail(customer.getEmail())) {
            errorMap.put("email","Email không đúng định dạng");
        }
        if (errorMap.isEmpty()){
            customerRepository.insertCustomer(customer);
        }
        return errorMap;
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
