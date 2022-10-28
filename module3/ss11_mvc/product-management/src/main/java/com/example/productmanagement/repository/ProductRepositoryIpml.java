package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryIpml implements ProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Samsung", 1000000, "Mo ta Samsung", "SS Producer"));
        products.put(2, new Product(2, "Nokia", 2000000, "Mo ta Nokia", "NKA Producer"));
        products.put(3, new Product(3, "Lenovo", 3000000, "Mo ta Lenovo", "LNV Producer"));
        products.put(4, new Product(4, "Dell", 4000000, "Mo ta Dell", "D Producer"));
        products.put(5, new Product(5, "Asus", 5000000, "Mo ta Asus", "A Producer"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for (Map.Entry<Integer, Product> product : products.entrySet()) {
            if (product.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                return product.getValue();
            }
        }
        return null;
    }

}
