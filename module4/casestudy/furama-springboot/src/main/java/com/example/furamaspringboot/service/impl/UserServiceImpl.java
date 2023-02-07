package com.example.furamaspringboot.service.impl;

import com.example.furamaspringboot.model.User;
import com.example.furamaspringboot.repository.IUserRepository;
import com.example.furamaspringboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IBaseService<User> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }
//    public User findUserByUsername(String username) {}
}
