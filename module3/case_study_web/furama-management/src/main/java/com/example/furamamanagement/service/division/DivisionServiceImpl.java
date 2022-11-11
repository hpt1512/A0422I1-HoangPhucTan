package com.example.furamamanagement.service.division;

import com.example.furamamanagement.model.Division;
import com.example.furamamanagement.repository.division.DivisionRepositoryImpl;
import com.example.furamamanagement.repository.division.IDivisionRepository;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    IDivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> selectAllDivisions() {
        return divisionRepository.selectAllDivisions();
    }
}
