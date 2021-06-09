package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.exceptions.*;
import com.desafio_1.demo.models.User;
import com.desafio_1.demo.repositories.IProductRepository;
import com.desafio_1.demo.repositories.IUserRepository;
import com.desafio_1.demo.services.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO product) throws UnhandledException, UserIdInvalidException, UserNotFoundException, ProductDateInvalidException, ProductDetailRequiredException, ProductCategoryInvalidException, ProductPriceInvalidException, ProductIdPostInvalidException {
        ProductResponseDTO productResponse = null;
        if(validateProduct(product)){
            productResponse = ProductMapper.toDTO(productRepository.addProduct(ProductMapper.toModel(product)));
        }

        return productResponse;
    }

    private boolean validateProduct(ProductRequestDTO product) throws UserIdInvalidException, UserNotFoundException, ProductDateInvalidException, ProductDetailRequiredException, ProductCategoryInvalidException, ProductPriceInvalidException, ProductIdPostInvalidException, UnhandledException {
        int userId = product.getUserId();

        if(userId<= 0){
            throw new UserIdInvalidException();
        }

        User user = userRepository.findUserById(userId);

        if(user == null){
            throw new UserNotFoundException(userId);
        }

        if(product.getDate() == null){
            throw new ProductDateInvalidException();
        }

        if(product.getDetail() == null){
            throw new ProductDetailRequiredException();
        }

        if(product.getCategory() <= 0){
            throw new ProductCategoryInvalidException();
        }

        if(product.getPrice() <= 0){
            throw new ProductPriceInvalidException();
        }

        if(product.getIdPost() <= 0){
            throw new ProductIdPostInvalidException();
        }

        return true;
    }
}
