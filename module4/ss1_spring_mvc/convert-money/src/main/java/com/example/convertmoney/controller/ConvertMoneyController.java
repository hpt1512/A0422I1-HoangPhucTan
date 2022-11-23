package com.example.convertmoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoneyController {

    @GetMapping("/")
    public String show() {
        return "index";
    }
    @GetMapping("/convert")
    public String ConvertMoney(Model model, @RequestParam int usd) {
        int vnd = usd * 23000;
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
