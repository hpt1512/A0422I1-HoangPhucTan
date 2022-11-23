package codegym.springdemo.repository;

import codegym.springdemo.bean.Student;

import java.util.List;

public interface IStudentRepository {
    void createOrUpdate(Student s);
    Student findById(String id);
    List<Student> findAll();
    void deleteById(String id);
}
