package com.example.furamaspringboot.repository;

import com.example.furamaspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
}
