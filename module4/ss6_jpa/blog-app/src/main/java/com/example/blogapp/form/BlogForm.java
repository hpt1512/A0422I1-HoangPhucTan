package com.example.blogapp.form;

public class BlogForm {
    private String id;
    private String name;
    private String content;
    private String categoryId;

    public BlogForm() {
    }

    public BlogForm(String id, String name, String content, String category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.categoryId = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
