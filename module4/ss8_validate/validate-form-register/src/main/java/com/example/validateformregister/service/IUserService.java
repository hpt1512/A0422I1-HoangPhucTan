package com.example.validateformregister.service;

import com.example.validateformregister.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void insert(User user);
}
