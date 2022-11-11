package com.example.furamamanagement.service.rent_type;

import com.example.furamamanagement.model.RentType;
import com.example.furamamanagement.repository.rent_type.IRenTypeRepository;
import com.example.furamamanagement.repository.rent_type.RentTypeRepositoryImpl;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {
    IRenTypeRepository renTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> selectAllRentTypes() {
        return renTypeRepository.selectAllRentTypes();
    }
}
