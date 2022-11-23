package com.example.appdictionary.controller;

import com.example.appdictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppDictionaryController {
    @Autowired
    DictionaryService dictionaryService;
    @GetMapping("/")
    public String show() {
        return "index";
    }
    @GetMapping("/find")
    public String findDictionary(Model model, @RequestParam String elWord) {
        model.addAttribute("vieWord", dictionaryService.convert(elWord));
        return "index";
    }
}
