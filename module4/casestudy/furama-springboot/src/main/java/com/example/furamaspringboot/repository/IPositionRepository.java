package com.example.furamaspringboot.repository;

import com.example.furamaspringboot.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
