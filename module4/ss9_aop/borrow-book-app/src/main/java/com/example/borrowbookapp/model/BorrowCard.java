package com.example.borrowbookapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity(name = "borrow_card")
public class BorrowCard {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBorrow;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePay;

    public BorrowCard() {
        Random random = new Random();
        this.id = random.nextInt(90000) + 10000;
    }

    public BorrowCard(Integer id, User user, Book book, Date dateBorrow, Date datePay) {
        Random random = new Random();
        this.id = random.nextInt(90000) + 10000;
        this.user = user;
        this.book = book;
        this.dateBorrow = dateBorrow;
        this.datePay = datePay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }
}
