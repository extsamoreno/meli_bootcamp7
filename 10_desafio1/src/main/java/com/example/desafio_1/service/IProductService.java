package com.example.desafio_1.service;

import com.example.desafio_1.exception.EmptyStringException;
import com.example.desafio_1.exception.NumberNotGreaterThanZero;
import com.example.desafio_1.exception.ProductExceptionNotFound;
import com.example.desafio_1.exception.ProductExceptionNotValid;
import com.example.desafio_1.service.dto.PostDTO;
import com.example.desafio_1.service.dto.ProductDTO;

public interface IProductService {

    void existsProduct(int product_id) throws ProductExceptionNotFound;

    void validateDTO(ProductDTO detail) throws ProductExceptionNotValid;
}
