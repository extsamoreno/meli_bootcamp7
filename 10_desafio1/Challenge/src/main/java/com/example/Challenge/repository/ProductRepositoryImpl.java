package com.example.Challenge.repository;


import com.example.Challenge.model.Product;
import com.example.Challenge.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements  IProductRepository{

    public final List<Product> dataBaseProducts = new ArrayList<>();

    @Override
    public String createPost(Product product) {
        if(product!= null) {
            dataBaseProducts.add(product);
            return "OK";
        }
        return "Fail";
    }

    @Override
    public List<Product> getAllProducts() {
        return dataBaseProducts;
    }
}
