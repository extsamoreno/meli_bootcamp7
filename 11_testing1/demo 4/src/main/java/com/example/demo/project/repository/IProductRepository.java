package com.example.demo.project.repository;

import com.example.demo.project.models.Product;

public interface IProductRepository {

    Product getById(Integer id);

    void addProduct(Product toProduct);
}
