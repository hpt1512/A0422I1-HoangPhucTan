package com.example.furamamanagement.repository.service_type;

import com.example.furamamanagement.model.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> selectAllServiceTypes();
}
