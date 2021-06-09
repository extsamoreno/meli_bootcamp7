package com.desafio_1.demo.repositories;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.Product;

public interface IProductRepository {
    Product addProduct(Product product) throws UnhandledException;
}
