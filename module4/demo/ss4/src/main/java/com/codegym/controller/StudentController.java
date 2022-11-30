package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import com.codegym.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

//    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @GetMapping("/list")
    public String getListStudent(Model model) {
        List<Student> students = iStudentService.getAll();
        model.addAttribute("listStudent", students);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable("id")Integer codeStudent, Model model) {
        System.out.println(codeStudent);
        Student student = iStudentService.findById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/detail")
    public String getDetailWithRequestParam(@RequestParam("id")Integer codeStudent, Model model) {
        System.out.println(codeStudent);
        Student student = iStudentService.findById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/create")
    public String getPageCreate(Model model) {
        model.addAttribute("student", new Student(0,"",0,0));
        String[] genderList = {"0", "1", "2"};
        model.addAttribute("genderList", genderList);
        return "create";
    }

    @PostMapping("/create")
    public String saveStudent(@ModelAttribute("student")Student temp,
                              RedirectAttributes redirectAttributes) {
        iStudentService.save(temp);
        redirectAttributes.addFlashAttribute("msg"," Thêm mới thành công");
        return "redirect:/list";
    }
}
