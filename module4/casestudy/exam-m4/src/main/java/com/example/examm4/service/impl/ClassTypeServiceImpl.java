package com.example.examm4.service.impl;

import com.example.examm4.model.ClassType;
import com.example.examm4.repository.IClassTypeRepository;
import com.example.examm4.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTypeServiceImpl implements IBaseService<ClassType> {
    @Autowired
    private IClassTypeRepository classTypeRepository;

    @Override
    public List<ClassType> findAll() {
        return classTypeRepository.findAll();
    }

    @Override
    public ClassType findById(Integer id) {
        return null;
    }

    @Override
    public void insert(ClassType classType) {

    }

    @Override
    public void update(ClassType classType) {

    }
}
