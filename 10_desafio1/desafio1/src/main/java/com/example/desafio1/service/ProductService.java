package com.example.desafio1.service;

import com.example.desafio1.model.Product;
import com.example.desafio1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void addProductToCatalog(Product product) {
        iProductRepository.createProduct(product);
    }
}
