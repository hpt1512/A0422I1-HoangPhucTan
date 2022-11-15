package com.example.m3phuctanthithuchanh.service;

import com.example.m3phuctanthithuchanh.model.Student;
import com.example.m3phuctanthithuchanh.repository.IBaseRepository;
import com.example.m3phuctanthithuchanh.repository.StudentRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements IBaseService<Student> {
    IBaseRepository<Student> studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return false;
    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }
}
