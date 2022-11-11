package com.example.furamamanagement.service.service_type;

import com.example.furamamanagement.model.ServiceType;
import com.example.furamamanagement.repository.service_type.IServiceTypeRepository;
import com.example.furamamanagement.repository.service_type.ServiceTypeRepositoryImpl;

import java.util.List;

public class ServiceTypeServiceImpl implements IServiceTypeService {
    IServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();

    @Override
    public List<ServiceType> selectAllServiceTypes() {
        return serviceTypeRepository.selectAllServiceTypes();
    }
}
