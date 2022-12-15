package com.example.studentclass.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", columnDefinition = "varchar(45)")
    private String name;
    @Column(name = "birthday")
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classRoom;

    public Student() {
    }

    public Student(int id, String name, Date birthday, Class classRoom) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.classRoom = classRoom;
    }

    public Student(String name, Date birthday, Class classRoom) {
        this.name = name;
        this.birthday = birthday;
        this.classRoom = classRoom;
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

    public Class getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Class classRoom) {
        this.classRoom = classRoom;
    }
}
