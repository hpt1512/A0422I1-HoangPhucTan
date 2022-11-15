package com.example.furamamanagement.service.service;

import com.example.furamamanagement.model.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IServiceService {
    List<Service> selectAllServices();
    Map<String, String> insertService(Service service) throws SQLException;
    boolean deleteService(int id) throws SQLException;
    boolean updateService(Service service) throws SQLException;
    Service getServiceById(int id);
    List<Service> findByNameRentService(String nameFind, String rentTypeFind, String serviceTypeFind);
}
