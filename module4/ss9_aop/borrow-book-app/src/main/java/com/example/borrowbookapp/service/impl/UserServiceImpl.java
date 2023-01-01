package com.example.borrowbookapp.service.impl;

import com.example.borrowbookapp.model.User;
import com.example.borrowbookapp.repository.IUserRepository;
import com.example.borrowbookapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
