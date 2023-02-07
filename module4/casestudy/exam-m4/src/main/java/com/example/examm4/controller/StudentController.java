package com.example.examm4.controller;

import com.example.examm4.model.Class;
import com.example.examm4.model.Student;
import com.example.examm4.service.IBaseService;
import com.example.examm4.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    IBaseService<Class> classService;
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("studentList", studentService.findAll());
        return "student/list";
    }
    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classRooms", classService.findAll());
        return "student/create";
    }
}
