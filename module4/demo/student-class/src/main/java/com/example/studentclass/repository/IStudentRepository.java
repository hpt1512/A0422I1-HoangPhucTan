package com.example.studentclass.repository;

import com.example.studentclass.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
