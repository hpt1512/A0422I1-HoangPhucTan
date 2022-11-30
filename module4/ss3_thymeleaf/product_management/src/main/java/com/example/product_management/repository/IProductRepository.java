package com.example.product_management.repository;

import com.example.product_management.bean.Product;

import java.util.List;

public interface IProductRepository {
    void createOrUpdate(Product s);
    Product findById(int id);
    List<Product> findAll();
    void deleteById(int id);
    List<Product> findByName(String name);
}
