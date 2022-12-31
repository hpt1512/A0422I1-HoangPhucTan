package com.example.borrowbookapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "borrow_card")
public class BorrowCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;
    private Date dateBorrow;
    private Date datePay;

    public BorrowCard() {
    }

    public BorrowCard(Integer id, User user, Book book, Date dateBorrow, Date datePay) {
        this.id = id;
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
