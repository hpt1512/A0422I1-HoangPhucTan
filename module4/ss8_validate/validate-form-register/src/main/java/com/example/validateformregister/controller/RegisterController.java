package com.example.validateformregister.controller;

import com.example.validateformregister.model.User;
import com.example.validateformregister.service.IUserService;
import com.example.validateformregister.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String formRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                           Model model) {
        UserValidate validate = new UserValidate();
        validate.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.insert(user);
        return "result";
    }
}
