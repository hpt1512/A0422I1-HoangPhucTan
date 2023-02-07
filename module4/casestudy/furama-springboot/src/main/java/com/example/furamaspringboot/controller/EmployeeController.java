package com.example.furamaspringboot.controller;

import com.example.furamaspringboot.model.*;
import com.example.furamaspringboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
    @Autowired
    private IBaseService<Employee> employeeService;
    @Autowired
    private IBaseService<Position> positionService;
    @Autowired
    private IBaseService<EducationDegree> educationDegreeService;
    @Autowired
    private IBaseService<Division> divisionService;
    @Autowired
    private IBaseService<User> userService;
    @GetMapping("/employee")
    public String list(Model model) {
        model.addAttribute("employeeList", employeeService.findAll());
        return "employee/list";
    }
    @GetMapping("/employee/create")
    public String formCreate(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        return "employee/create";
    }
    @PostMapping("/employee/doCreate")
    public String doCreate(@ModelAttribute Employee employee, @RequestParam String username,
                           @RequestParam String password, RedirectAttributes redirectAttributes) {
        User user = new User(username, password);
        userService.insert(user);
        employee.setUser(user);
        employeeService.insert(employee);
        redirectAttributes.addFlashAttribute("mess", "Create employee successfully");
        return "redirect:/employee";
    }
    @GetMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("users", userService.findAll());
        return "employee/edit";
    }
    @PostMapping("/employee/doEdit")
    public String doEdit(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.update(employee);
        redirectAttributes.addFlashAttribute("mess", "Update employee successfully");
        return "redirect:/";
    }
}
