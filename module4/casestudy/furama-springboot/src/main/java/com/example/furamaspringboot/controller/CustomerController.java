package com.example.furamaspringboot.controller;

import com.example.furamaspringboot.model.Customer;
import com.example.furamaspringboot.model.CustomerType;
import com.example.furamaspringboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    IBaseService<Customer> customerService;
    @Autowired
    IBaseService<CustomerType> customerTypeService;
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        return "customer/list";
    }
    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/create";
    }
    @PostMapping("/doCreate")
    public String doCreate(@Valid @ModelAttribute Customer customer, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        }
        customerService.insert(customer);
        redirectAttributes.addFlashAttribute("mess", "Create customer successfully");
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/edit";
    }
    @PostMapping("/doEdit")
    public String edit(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "Edit customer successfully");
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        customerService.delete(customerService.findById(id));
        redirectAttributes.addFlashAttribute("mess", "Delete customer successfully");
        return "redirect:/customer";
    }
}
