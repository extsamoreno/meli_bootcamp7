package com.desafio_1.demo.repositories;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepository implements IProductRepository{

    private ArrayList<Product> listProducts = new ArrayList<>();

    @Override
    public Product addProduct(ProductRequestDTO product) {
        return null;
    }
}
