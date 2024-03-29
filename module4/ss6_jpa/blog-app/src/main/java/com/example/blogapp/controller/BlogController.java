package com.example.blogapp.controller;

import com.example.blogapp.model.Blog;
import com.example.blogapp.model.Category;
import com.example.blogapp.service.IBlogService;
import com.example.blogapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/list")
    public String showList(Model model) {
        model.addAttribute("blogList", blogService.getAll());
        model.addAttribute("categoryList", categoryService.getAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model) {
        Blog blog = new Blog();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);

        blog.setDateTimeCreated(formatDateTime);

        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryService.getAll());
        return "/create";
    }
    @PostMapping("/create")
    public String createStudent(@ModelAttribute("blog") Blog blog,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") int id) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryService.getAll());
        return "detail";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable("id") int id) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blogUpdate", blog);
        model.addAttribute("categoryList", categoryService.getAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("blog") Blog blog, Model model,
                         RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("msg","Cập nhật mới thành công");
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        Blog blog = blogService.getBlogById(id);
        blogService.delete(blog);
        return "redirect:/list";
    }
    @GetMapping("/findBlogByName")
    public String findBlogByName(Model model, @RequestParam("nameFind") String nameFind) {
        if ("".equals(nameFind)) {
            return "redirect:/list";
        }
        model.addAttribute("blogList", blogService.findBlogByName(nameFind));
        model.addAttribute("categoryList", categoryService.getAll());
        return "list";
    }
    @GetMapping("/findBlogByCategory")
    public String findBlogByCategory(@RequestParam("category_id") int category_id, Model model) {
        Category category = categoryService.getCategoryById(category_id);
        model.addAttribute("blogList", blogService.findBlogByCategory(category));
        model.addAttribute("categoryList", categoryService.getAll());
        return "list";
    }
}
