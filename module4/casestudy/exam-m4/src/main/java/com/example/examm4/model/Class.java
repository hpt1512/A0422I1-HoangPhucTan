package com.example.examm4.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "class_tyoe_id")
    private ClassType classType;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classRoom")
    private List<Student> studentList;

    public Class() {
    }

    public Class(Integer id, String name, ClassType classType) {
        this.id = id;
        this.name = name;
        this.classType = classType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
