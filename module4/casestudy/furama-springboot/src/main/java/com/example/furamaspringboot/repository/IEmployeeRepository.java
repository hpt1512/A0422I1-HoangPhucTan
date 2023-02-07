package com.example.furamaspringboot.repository;

import com.example.furamaspringboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
