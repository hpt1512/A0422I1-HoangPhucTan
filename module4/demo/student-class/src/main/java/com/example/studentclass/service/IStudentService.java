package com.example.studentclass.service;

import com.example.studentclass.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    void save(Student student);
    void update(Student student);
    void delete(Student student);
    Student getStudentById(int id);
}
