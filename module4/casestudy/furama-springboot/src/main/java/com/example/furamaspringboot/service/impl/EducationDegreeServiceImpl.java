package com.example.furamaspringboot.service.impl;

import com.example.furamaspringboot.model.EducationDegree;
import com.example.furamaspringboot.repository.IEducationDegreeRepository;
import com.example.furamaspringboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IBaseService<EducationDegree> {
   @Autowired
   private IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void insert(EducationDegree educationDegree) {

    }

    @Override
    public void update(EducationDegree educationDegree) {

    }

    @Override
    public void delete(EducationDegree educationDegree) {

    }

    @Override
    public EducationDegree findById(Integer id) {
        return null;
    }
}
