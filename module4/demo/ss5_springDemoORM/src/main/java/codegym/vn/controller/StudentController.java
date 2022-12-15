package codegym.vn.controller;

import codegym.vn.bean.Student;
import codegym.vn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"/student/list", "/"}, method = RequestMethod.GET)
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }

    @GetMapping("/student/update")
    public String showUpdate(Model model, @RequestParam("id") String id) {
        model.addAttribute("student", studentService.findById(id));
        return "update";
    }

    @GetMapping("/student/create")
    public String showCreate(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/student/create")
    public String doCreate(@ModelAttribute("student") Student student) {
        studentService.create(student);
        return "redirect:/student/list";
    }

    @PostMapping("/student/update")
    public String doUpdate(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/student/list";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("student/detail/{id}")
    public String detail(@PathVariable("id") String id, Model  model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "detail";
    }

   @PostMapping("student/search")
    public String searchByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("students", studentService.findByName(name));
        return "list";
    }
}
