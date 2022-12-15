package com.example.blogapp.repository;

import com.example.blogapp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository <Blog, Integer> {
    List<Blog> findBlogByNameContaining(String name);
    List<Blog> findBlogByCategory(String categoryName);
}
