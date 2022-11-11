package com.example.furamamanagement.service.employee;

import com.example.furamamanagement.model.Employee;
import com.example.furamamanagement.repository.employee.EmployeeRepositoryImpl;
import com.example.furamamanagement.repository.employee.IEmployeeRepository;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> selectAllEmployees() {
        return employeeRepository.selectAllEmployees();
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }
}
