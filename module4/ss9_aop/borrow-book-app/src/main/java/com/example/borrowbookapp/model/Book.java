package com.example.borrowbookapp.model;

import javax.persistence.*;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @Column(columnDefinition = "varchar(45)")
    private String author;
    private Integer quantity;
    @Column(columnDefinition = "varchar(45)")
    private String image;

    public Book() {
    }

    public Book(Integer id, String name, String author, Integer quantity, String image) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.image = image;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
