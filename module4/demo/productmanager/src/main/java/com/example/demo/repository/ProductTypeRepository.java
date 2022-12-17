package com.example.demo.repository;

import com.example.demo.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType,Integer> {
}
