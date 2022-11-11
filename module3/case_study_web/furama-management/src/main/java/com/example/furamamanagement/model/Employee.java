package com.example.furamamanagement.model;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private Date birthday;
    private String cmnd;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;
    private int idPosition; //vi tri
    private int idEducationDegree;
    private int idDivision; //bo phan

    public Employee() {
    }

    public Employee(int id, String name, Date birthday, String cmnd, double salary, String phoneNumber, String email, String address, int idPosition, int idEducationDegree, int idDivision) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cmnd = cmnd;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idEducationDegree = idEducationDegree;
        this.idDivision = idDivision;
    }

    public Employee(String name, Date birthday, String cmnd, double salary, String phoneNumber, String email, String address, int idPosition, int idEducationDegree, int idDivision) {
        this.name = name;
        this.birthday = birthday;
        this.cmnd = cmnd;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idEducationDegree = idEducationDegree;
        this.idDivision = idDivision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(int idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }
}
