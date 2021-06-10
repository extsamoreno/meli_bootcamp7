package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.dtos.ProductPromoCountDTO;
import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.exceptions.*;

public interface IProductService {
    void addProduct(ProductRequestDTO product) throws UnhandledException, BadRequestException;

    ProductResponseDTO findProductsByFollowedId(int userId, String order) throws UnhandledException,  BadRequestException;

    ProductPromoCountDTO findProductsPromoCountByUserId(int userId) throws UnhandledException, BadRequestException;

    ProductResponseDTO findProductsPromoByUserId(int userId) throws UnhandledException,  BadRequestException;
}
