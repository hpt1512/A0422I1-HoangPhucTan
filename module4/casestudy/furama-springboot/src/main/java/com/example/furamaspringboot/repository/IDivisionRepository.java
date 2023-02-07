package com.example.furamaspringboot.repository;

import com.example.furamaspringboot.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
