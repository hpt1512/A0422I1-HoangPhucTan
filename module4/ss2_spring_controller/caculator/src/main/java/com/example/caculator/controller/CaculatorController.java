package com.example.caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/")
    public String show() {
        return "index";
    }

    @GetMapping("/count")
    public String count(Model model, @RequestParam("num1") double num1, @RequestParam("num2") double num2,
                        @RequestParam("calculation") String calculation) {
        double result = 0;
        if (calculation.equals("+")) {
            result = num1 + num2;
        }
        if (calculation.equals("-")) {
            result = num1 - num2;
        }
        if (calculation.equals("*")) {
            result = num1 * num2;
        }
        if (calculation.equals("/")) {
            result = num1 / num2;
        }

        model.addAttribute("result", result);
        return "index";
    }
}
