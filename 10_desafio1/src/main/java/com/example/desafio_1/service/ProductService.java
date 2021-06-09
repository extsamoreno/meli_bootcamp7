package com.example.desafio_1.service;

import com.example.desafio_1.exception.ProductExceptionNotFound;
import com.example.desafio_1.exception.ProductExceptionNotValid;
import com.example.desafio_1.repository.IProductRepository;
import com.example.desafio_1.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;

    @Override
    public void existsProduct(int product_id) throws ProductExceptionNotFound {
        if(productRepository.getById(product_id) == null)
            throw new ProductExceptionNotFound(product_id);
    }

    @Override
    public void validateDTO(ProductDTO detail) throws ProductExceptionNotValid {
        try {
            Utils.validateIntGreaterThanZero(detail.getProduct_id(), "product_id");
            Utils.validateStringEmpty(detail.getProductName(), "productName");
            Utils.validateStringEmpty(detail.getType(), "type");
            Utils.validateStringEmpty(detail.getBrand(), "brand");
            Utils.validateStringEmpty(detail.getColor(), "color");
        }
        catch (Exception e) {
            throw new ProductExceptionNotValid(e.getMessage());
        }

    }
}
