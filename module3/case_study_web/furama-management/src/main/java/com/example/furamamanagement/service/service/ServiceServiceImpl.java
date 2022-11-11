package com.example.furamamanagement.service.service;

import com.example.furamamanagement.model.Service;
import com.example.furamamanagement.repository.service.IServiceRepository;
import com.example.furamamanagement.repository.service.ServiceRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public List<Service> selectAllServices() {
        return serviceRepository.selectAllServices();
    }

    @Override
    public void insertService(Service service) throws SQLException {
        serviceRepository.insertService(service);
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return serviceRepository.deleteService(id);
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return serviceRepository.updateService(service);
    }

    @Override
    public Service getServiceById(int id) {
        return serviceRepository.getServiceById(id);
    }

    @Override
    public List<Service> findByNameRentService(String nameFind, String rentTypeFind, String serviceTypeFind) {
        return serviceRepository.findByNameRentService(nameFind, rentTypeFind, serviceTypeFind);
    }
}
