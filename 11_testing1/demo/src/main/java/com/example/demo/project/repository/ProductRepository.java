package com.example.demo.project.repository;

import com.example.demo.project.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository{

    @Override
    public Product getById(Integer id) {

        return null;
    }
}
