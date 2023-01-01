package com.example.borrowbookapp.service;

import com.example.borrowbookapp.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Integer id);
}
