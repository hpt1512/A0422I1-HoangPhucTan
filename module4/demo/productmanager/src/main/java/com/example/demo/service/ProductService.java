package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void delete(Integer id);
    void update(Product product);
    List<Product> findAll();
    Product findById(Integer id);
    List<Product> findByName(String name);
}
