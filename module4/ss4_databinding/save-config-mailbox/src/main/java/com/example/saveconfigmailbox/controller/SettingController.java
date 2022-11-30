package com.example.saveconfigmailbox.controller;

import com.example.saveconfigmailbox.bean.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingController {
    Setting setting = new Setting("English", 15, true, "tan");
    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("setting", setting);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 20, 25, 50});
        return "settingInfo";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("setting") Setting setting, ModelMap model) {
        return "settingInfo";
    }
}
