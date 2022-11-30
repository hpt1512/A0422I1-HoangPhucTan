package com.example.product_management.service;

import com.example.product_management.bean.Product;

import java.util.List;

public interface IProductService {
    void createOrUpdate(Product s);
    Product findById(int id);
    List<Product> findAll();
    void deleteById(int id);
    List<Product> findByName(String name);
}
