package com.example.furamamanagement.model;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
    private int id;

    private int customerTypeId;
    private CustomerType customerType;
    private String name;
    private Date birthday;
//    private String birthday;
    private boolean gender;
    private String cmnd;
    private String phoneNumber;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int customerTypeId, String name, Date birthday, boolean gender, String cmnd, String phoneNumber, String email, String address) {
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public Customer(int id, CustomerType customerType, String name, Date birthday, boolean gender, String cmnd, String phoneNumber, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Customer(int id, int customerTypeId, String name, Date birthday, boolean gender, String cmnd, String phoneNumber, String email, String address) {
        this.id = id;
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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
}
