package com.example.examm4.service.impl;

import com.example.examm4.model.Class;
import com.example.examm4.repository.IClassRepository;
import com.example.examm4.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements IBaseService<Class> {
    @Autowired
    private IClassRepository classRepository;

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Class findById(Integer id) {
        return classRepository.findById(id).orElse(null);
    }

    @Override
    public void insert(Class aClass) {
        classRepository.save(aClass);
    }

    @Override
    public void update(Class aClass) {
        classRepository.save(aClass);
    }
}
