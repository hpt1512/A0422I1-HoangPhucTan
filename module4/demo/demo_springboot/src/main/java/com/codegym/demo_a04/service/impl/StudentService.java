package com.codegym.demo_a04.service.impl;

import com.codegym.demo_a04.model.Student;
import com.codegym.demo_a04.repository.IStudentRepository;
import com.codegym.demo_a04.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
//        Optional<Student> student = iStudentRepository.findById(id);
//        if(student.isPresent()) {
//            return student.get();
//        } else {
//            return null;
//        }

        return iStudentRepository.findById(id).orElse(null);
    }
}
