package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    boolean remove(int id) throws SQLException;
    List<Product> findByName(String name);
}
