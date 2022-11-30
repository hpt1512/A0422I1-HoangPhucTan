package com.example.product_management.service;

import com.example.product_management.bean.Product;
import com.example.product_management.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public void createOrUpdate(Product s) {
        productRepository.createOrUpdate(s);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
