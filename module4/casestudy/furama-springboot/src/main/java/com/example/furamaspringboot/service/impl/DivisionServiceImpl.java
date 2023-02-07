package com.example.furamaspringboot.service.impl;

import com.example.furamaspringboot.model.Division;
import com.example.furamaspringboot.repository.IDivisionRepository;
import com.example.furamaspringboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IBaseService<Division> {
    @Autowired
    IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void insert(Division division) {

    }

    @Override
    public void update(Division division) {

    }

    @Override
    public void delete(Division division) {

    }

    @Override
    public Division findById(Integer id) {
        return null;
    }
}
