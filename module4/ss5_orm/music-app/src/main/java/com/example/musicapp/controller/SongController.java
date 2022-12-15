package com.example.musicapp.controller;

import com.example.musicapp.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("songList", songService.getAll());
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model) {

        return "create";
    }

}
