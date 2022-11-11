package com.example.furamamanagement.repository.rent_type;

import com.example.furamamanagement.model.RentType;

import java.util.List;

public interface IRenTypeRepository {
    List<RentType> selectAllRentTypes();
}
