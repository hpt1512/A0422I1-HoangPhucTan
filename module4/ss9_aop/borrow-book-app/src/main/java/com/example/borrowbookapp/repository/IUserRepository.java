package com.example.borrowbookapp.repository;

import com.example.borrowbookapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
