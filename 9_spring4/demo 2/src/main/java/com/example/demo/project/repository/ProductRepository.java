package com.example.demo.project.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository{

    @Override
    public Product getById(Integer id) {
        return new Product(1,"telefono","asd123" ,5);
    }
}
