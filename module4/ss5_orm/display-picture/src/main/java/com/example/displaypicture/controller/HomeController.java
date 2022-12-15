package com.example.displaypicture.controller;

import com.example.displaypicture.model.Comment;
import com.example.displaypicture.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    ICommentService commentService;
    @GetMapping("")
    public String home(Model model) {
        Date date = new Date();
        model.addAttribute("comment", new Comment(null, null, "", "", date));
        model.addAttribute("commentList", commentService.findAll());
        return "home";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("comment") Comment comment,
                            Model model) {
        commentService.insert(comment);
        return "redirect:/";
    }
}
