package com.example.desafio1.service;

import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.model.Product;

import java.util.HashMap;

public interface IProductService {
    void addProductToCatalog(Product product);

    Product checkProductConsistency(Product productRequest)
            throws ProductNotFoundException, ProductInconsistencyException;
    HashMap<Integer, Product> getCatalog();
}
