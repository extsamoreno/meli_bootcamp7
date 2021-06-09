package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.exceptions.*;

public interface IProductService {
    ProductResponseDTO addProduct(ProductRequestDTO product) throws UnhandledException, UserIdInvalidException, UserNotFoundException, ProductDateInvalidException, ProductDetailRequiredException, ProductCategoryInvalidException, ProductPriceInvalidException, ProductIdPostInvalidException;
}
