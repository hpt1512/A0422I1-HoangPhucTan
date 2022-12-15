package com.example.displaypicture.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "`point`")
    private Integer point;
    @Column(name = "author")
    private String author;
    @Column(name = "feedback")
    private String feedBack;
    @Column(name = "`date`")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Comment() {
    }

    public Comment(Integer id, Integer point, String author, String feedBack, Date date) {
        this.id = id;
        this.point = point;
        this.author = author;
        this.feedBack = feedBack;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
