package com.example.furamaspringboot.repository;

import com.example.furamaspringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
}
