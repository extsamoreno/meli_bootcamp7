package com.example.desafio1.service.product;

import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.exception.WrongProductIdException;
import com.example.desafio1.model.Product;

import java.util.HashMap;

public interface IProductService {
    void addProductToCatalog(Product product);

    Product checkProductConsistency(Product productRequest)
            throws ProductNotFoundException, ProductInconsistencyException,
            WrongProductIdException;
    HashMap<Integer, Product> getCatalog();
}
