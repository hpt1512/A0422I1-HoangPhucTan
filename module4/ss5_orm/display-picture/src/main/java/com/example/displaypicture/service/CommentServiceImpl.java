package com.example.displaypicture.service;

import com.example.displaypicture.model.Comment;
import com.example.displaypicture.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepository commentRepository;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();

    }

    @Override
    public void insert(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }
}
