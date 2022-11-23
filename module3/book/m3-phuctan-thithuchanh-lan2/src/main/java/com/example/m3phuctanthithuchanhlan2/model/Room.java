package com.example.m3phuctanthithuchanhlan2.model;

import java.util.Date;

public class Room {
    private int id;
    private String username;
    private String phoneNumber;
    private Date dateStart;
    private int idPay;
    private String note;

    public Room() {
    }

    public Room(int id, String username, String phoneNumber, Date dateStart, int idPay, String note) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.dateStart = dateStart;
        this.idPay = idPay;
        this.note = note;
    }

    public Room(String username, String phoneNumber, Date dateStart, int idPay, String note) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.dateStart = dateStart;
        this.idPay = idPay;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public int getIdPay() {
        return idPay;
    }

    public void setIdPay(int idPay) {
        this.idPay = idPay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
