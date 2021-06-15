package com.example.demo.project.repositories;

import com.example.demo.project.models.Product;

public interface IProductRepository {

    Product getById(Integer id);

    boolean createProduct(Product product);

}
