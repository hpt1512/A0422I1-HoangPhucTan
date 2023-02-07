package com.example.examm4.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ClassType {
    @Id
    private Integer id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classType")
    private List<Class> classList;

    public ClassType() {
    }

    public ClassType(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Class> getClassList() {
        return classList;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }
}
