package com.example.blogapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "blog")
public class Blog {
    @Id
    //tự động tăng
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", columnDefinition = "varchar(50)")
    private String name;
    @Column(name = "content", columnDefinition = "varchar(50)")
    private String content;
    @Column(name = "datetime_created")
    private String dateTimeCreated;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String name, String content, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.category = category;
    }

    public Blog(Integer id, String name, String content, String dateTimeCreated, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.dateTimeCreated = dateTimeCreated;
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(String dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }
}
