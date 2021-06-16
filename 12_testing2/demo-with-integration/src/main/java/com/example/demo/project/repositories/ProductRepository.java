package com.example.demo.project.repositories;

import com.example.demo.project.dtos.ProductDTO;
import com.example.demo.project.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository{

    @Override
    public Product getById(Integer id) {
        return new Product(1,"mouse","asd123" ,10);
    }

    @Override
    public boolean createProduct(Product product) {
        return true;
    }
}
