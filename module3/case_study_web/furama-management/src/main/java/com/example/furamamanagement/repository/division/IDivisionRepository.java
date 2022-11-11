package com.example.furamamanagement.repository.division;

import com.example.furamamanagement.model.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> selectAllDivisions();
}
