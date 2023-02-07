package com.example.examm4.repository;

import com.example.examm4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, String> {
}
