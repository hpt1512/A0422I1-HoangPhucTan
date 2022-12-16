package com.example.blogapp.service;

import com.example.blogapp.model.Blog;
import com.example.blogapp.model.Category;
import com.example.blogapp.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public List<Blog> getAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public Blog getBlogById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findBlogByName(String name) {
        return iBlogRepository.findBlogByNameContaining(name);
    }

    @Override
    public List<Blog> findBlogByCategory(Category category) {
        return iBlogRepository.findBlogByCategory(category);
    }
}
