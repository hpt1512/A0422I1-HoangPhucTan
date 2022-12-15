package com.example.blogapp.service;

import com.example.blogapp.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    void save(Category category);
    void update(Category category);
    void delete(Category category);
    Category getCategoryById(int id);
}
