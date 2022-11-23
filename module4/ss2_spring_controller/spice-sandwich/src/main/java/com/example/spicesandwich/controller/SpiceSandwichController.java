package com.example.spicesandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SpiceSandwichController {
    @GetMapping("/")
    public String show() {
        return "index";
    }

    @GetMapping("/save")
    public String save(Model model, @RequestParam("spice") String[] spices) {
        model.addAttribute("spices", spices);
        return "index";
    }
}
