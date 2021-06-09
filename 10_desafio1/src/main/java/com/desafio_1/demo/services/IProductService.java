package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;

public interface IProductService {
    ProductResponseDTO addProduct(ProductRequestDTO product);
}
