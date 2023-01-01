package com.example.borrowbookapp.controller;

import com.example.borrowbookapp.model.Book;
import com.example.borrowbookapp.model.BorrowCard;
import com.example.borrowbookapp.service.IBookService;
import com.example.borrowbookapp.service.IBorrowCardService;
import com.example.borrowbookapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class BorrowCardController {
    @Autowired
    IBookService bookService;
    @Autowired
    IBorrowCardService borrowCardService;
    @Autowired
    IUserService userService;
    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.findById(id);
        BorrowCard borrowCard = new BorrowCard();

        borrowCard.setBook(book);
        borrowCard.setUser(userService.findById(1));
        borrowCard.setDateBorrow(new Date());

        model.addAttribute("borrowCard", borrowCard);
        model.addAttribute("book", book);
        return "borrow";
    }

    @PostMapping("/doBorrow")
    public String doBorrow(@ModelAttribute("borrowCard") BorrowCard borrowCard) {
        if (borrowCard.getBook().getQuantity() <= 0) {
            return "error_amount";
        } else {
            borrowCardService.add(borrowCard);
            // trigger giảm số lượng sách xuống 1
            return "redirect:/borrow_card";
        }
    }

    @GetMapping("/borrow_card")
    public String listBorrowCard(Model model) {
        model.addAttribute("listBorrow", borrowCardService.findAll());
        return "list_borrow";
    }

    @GetMapping("/payBook")
    public String payBook() {
        return "pay_book";
    }

    @PostMapping("doPay")
    public String doPay(@RequestParam("borrowCardId") Integer borrowCardId, Model model) {
        BorrowCard borrowCard = borrowCardService.findById(borrowCardId);
        String mess = "";
        if (borrowCard == null) {
            mess = "Not found borrow card, can't pay book";
        } else {
            borrowCardService.delete(borrowCard);
            mess = "Pay book successfully";
        }
        model.addAttribute("mess", mess);
        return "pay_book";
    }

//    @GetMapping("payBook/{id}")
//    public String payBook(@PathVariable("id") Integer id) {
//        BorrowCard borrowCard = borrowCardService.findById(id);
//        borrowCardService.delete(borrowCard);
//        // trigger tăng số lượng sách lên 1
//        return "redirect:/";
//    }
}
