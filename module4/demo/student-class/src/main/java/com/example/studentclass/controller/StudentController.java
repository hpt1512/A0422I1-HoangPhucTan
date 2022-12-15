package com.example.studentclass.controller;

import com.example.studentclass.model.Class;
import com.example.studentclass.model.Student;
import com.example.studentclass.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;
    @GetMapping("/student/list")
    public String list(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "student/list";
    }
    @GetMapping("/student/create")
    public String showCreatePage(Model model) {
        Student student =  new Student();
        student.setName("abc");
        Class className = new Class();
        className.setId(1);
        className.setName("A0422I1");
        student.setClassRoom(className);
        model.addAttribute("student",student);
        return "student/create";
    }
    @PostMapping("/student/docreate")
    public String createStudent(@ModelAttribute("student") Student student,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        studentService.save(student);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/student/list";
    }
}
