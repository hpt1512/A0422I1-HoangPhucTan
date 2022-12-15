package com.example.blogapp.controller;

import com.example.blogapp.model.Category;
import com.example.blogapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/list")
    public  String list(Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        return "category/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }
    @PostMapping("/create")
    public  String doCreate(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/category/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Category category = categoryService.getCategoryById(id);
        categoryService.delete(category);
        return "redirect:/category/list";
    }
    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }
    @PostMapping("edit")
    public String doEdit(@ModelAttribute("category") Category category) {
        categoryService.update(category);
        return "redirect:/category/list";
    }
}
