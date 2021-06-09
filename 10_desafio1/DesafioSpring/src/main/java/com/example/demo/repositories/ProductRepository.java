package com.example.demo.repositories;

import com.example.demo.model.Product;


public interface ProductRepository {

    Product findProductById(int product_id);
}
