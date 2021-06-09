package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO product) {
        return null;
    }
}
