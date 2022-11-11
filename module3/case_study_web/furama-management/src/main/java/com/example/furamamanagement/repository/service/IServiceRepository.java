package com.example.furamamanagement.repository.service;

import com.example.furamamanagement.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceRepository {
    List<Service> selectAllServices();
    void insertService(Service service) throws SQLException;
    boolean deleteService(int id) throws SQLException;
    boolean updateService(Service service) throws SQLException;
    Service getServiceById(int id);
    List<Service> findByNameRentService(String nameFind, String rentTypeFind, String serviceTypeFind);
}
