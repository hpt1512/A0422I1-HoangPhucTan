package com.example.borrowbookapp.controller;

import com.example.borrowbookapp.model.Book;
import com.example.borrowbookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @GetMapping("/")
    public String listBook(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "list_book";
    }
    @GetMapping("/detail/{id}")
    public String bookDetail(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "detail";
    }
}
