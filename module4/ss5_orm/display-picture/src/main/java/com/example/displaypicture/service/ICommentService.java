package com.example.displaypicture.service;

import com.example.displaypicture.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void insert(Comment comment);
    void delete(Comment comment);

}
