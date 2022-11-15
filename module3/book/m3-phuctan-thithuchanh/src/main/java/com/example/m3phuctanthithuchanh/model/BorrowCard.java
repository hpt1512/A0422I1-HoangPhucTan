package com.example.m3phuctanthithuchanh.model;

import java.util.Date;

public class BorrowCard {
    private int id;
    private String idRorrow;
    private int idBook;
    private int idStudent;
    private boolean status;
    private Date date_start;
    private Date date_end;

    public BorrowCard() {
    }

    public BorrowCard(int id, String idRorrow, int idBook, int idStudent, boolean status, Date date_start, Date date_end) {
        this.id = id;
        this.idRorrow = idRorrow;
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    public BorrowCard(String idRorrow, int idBook, int idStudent, boolean status, Date date_start, Date date_end) {
        this.idRorrow = idRorrow;
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    public BorrowCard(String idRorrow, int idBook, int idStudent, Date date_start, Date date_end) {
        this.idRorrow = idRorrow;
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdRorrow() {
        return idRorrow;
    }

    public void setIdRorrow(String idRorrow) {
        this.idRorrow = idRorrow;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }
}
