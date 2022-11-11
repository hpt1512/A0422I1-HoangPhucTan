package com.example.furamamanagement.service.employee;

import com.example.furamamanagement.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAllEmployees();
    void insertEmployee(Employee employee) throws SQLException;
    boolean deleteEmployee(int id) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int id);
    List<Employee> findByName(String name);
}
