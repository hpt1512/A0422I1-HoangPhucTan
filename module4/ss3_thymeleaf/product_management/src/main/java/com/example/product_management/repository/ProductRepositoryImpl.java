package com.example.product_management.repository;

import com.example.product_management.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Nokia", 2000));
        productMap.put(2, new Product(2, "Samsung", 3000));
        productMap.put(3, new Product(3, "Lennovo", 4000));
        productMap.put(4, new Product(4, "Dell", 5000));
        productMap.put(5, new Product(5, "Asus", 6000));

    }

    @Override
    public void createOrUpdate(Product s) {
        productMap.put(s.getId(), s);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void deleteById(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        List<Product> products = this.findAll();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}
