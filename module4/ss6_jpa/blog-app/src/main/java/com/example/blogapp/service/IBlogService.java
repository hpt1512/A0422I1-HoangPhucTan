package com.example.blogapp.service;

import com.example.blogapp.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();
    void save(Blog blog);
    void update(Blog blog);
    void delete(Blog blog);
    Blog getBlogById(int id);
    List<Blog> findBlogByName(String name);
    List<Blog> findBlogByCategory(String categoryName);
}
