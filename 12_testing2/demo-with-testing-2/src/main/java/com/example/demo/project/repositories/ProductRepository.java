package com.example.demo.project.repositories;

import com.example.demo.project.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository{

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public boolean createProduct(Product product) {
        return true;
    }
}
