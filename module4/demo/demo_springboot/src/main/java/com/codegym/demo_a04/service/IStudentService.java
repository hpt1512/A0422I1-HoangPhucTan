package com.codegym.demo_a04.service;

import com.codegym.demo_a04.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    void save(Student student);

    Student getStudentById(int id);
}
