package com.example.examm4.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classRoom;

    public Student() {
    }

    public Student(String id, String name, String phoneNumber, String email, Class classRoom) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoom = classRoom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Class getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Class classRoom) {
        this.classRoom = classRoom;
    }
}
