package com.example.furamaspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeComtroller {
    @GetMapping("")
    public String home() {
        return "home";
    }
}
