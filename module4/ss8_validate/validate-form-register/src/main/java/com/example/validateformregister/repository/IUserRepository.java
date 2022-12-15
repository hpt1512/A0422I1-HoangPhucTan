package com.example.validateformregister.repository;

import com.example.validateformregister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
