package com.desafio_1.demo.services;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.desafio_1.demo.dtos.*;
import com.desafio_1.demo.exceptions.*;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.User;
import com.desafio_1.demo.repositories.IProductRepository;
import com.desafio_1.demo.repositories.IUserRepository;
import com.desafio_1.demo.services.constants.OrderConstant;
import com.desafio_1.demo.services.helpers.UserValidatorHelper;
import com.desafio_1.demo.services.mappers.ProductListMapper;
import com.desafio_1.demo.services.mappers.ProductMapper;
import com.desafio_1.demo.services.mappers.ProductPromoCountMapper;
import com.desafio_1.demo.services.validators.ProductDetailValidator;
import com.desafio_1.demo.services.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public void addProduct(ProductRequestDTO product) throws UnhandledException, BadRequestException {

        if(validateProduct(product) && validateProductDetail(product.getDetail())){
            productRepository.addProduct(ProductMapper.toModel(product));
        }

    }

    @Override
    public ProductResponseDTO findProductsByFollowedId(int userId, String order) throws UnhandledException, BadRequestException {

        User user = userRepository.findUserById(userId);

        UserValidatorHelper.validateUserExist(user);

        ArrayList<User> followed = userRepository.findFollowedByUserId(userId, (a, b)->a.compareTo(b));

        List<Integer> usersId = followed.stream().map(User::getId).collect(Collectors.toList());

        ProductResponseDTO productsFollowed = ProductListMapper.toDTO(user, productRepository.findProductsByFollowedId(usersId, createComparatorDate(order)));

        return productsFollowed;
    }

    @Override
    public ProductPromoCountDTO findProductsPromoCountByUserId(int userId) throws UnhandledException, BadRequestException {

        User user = userRepository.findUserById(userId);

        UserValidatorHelper.validateUserExist(user);

        ArrayList<Product> products = productRepository.findProductsPromoByUserId(userId, createComparatorDate(null));

        return ProductPromoCountMapper.toDTO(user, products.size());
    }

    @Override
    public ProductResponseDTO findProductsPromoByUserId(int userId) throws UnhandledException, BadRequestException {

        User user = userRepository.findUserById(userId);

        UserValidatorHelper.validateUserExist(user);

        ArrayList<Product> products = productRepository.findProductsPromoByUserId(userId, createComparatorDate(null));

        return ProductListMapper.toDTO(user,products);
    }

    private Comparator<LocalDate> createComparatorDate(String order){
        Comparator<LocalDate> comparator = (a, b)->b.compareTo(a);

        if(order != null && order.equals(OrderConstant.OrderDateDesc)){
            comparator = (a, b)->a.compareTo(b);
        }

        return comparator;
    }


    private boolean validateProduct(ProductRequestDTO product) throws
            UnhandledException, BadRequestException {

        User user = userRepository.findUserById(product.getUserId());
        UserValidatorHelper.validateUserExist(user);

        Validator<ProductRequestDTO> validator = new ProductValidator();
        ValidationResult result = validator.validate(product);

        if(!result.isValid()){
            throw new BadRequestException(result.getErrors().toString());
        }

        if(product.isHasPromo() && product.getDiscount() <= 0)
            throw new BadRequestException("Para añadir un producto en promocion, el descuento debe ser mayor a 0");

        if(!product.isHasPromo() && product.getDiscount() > 0)
            throw new BadRequestException("Para añadir un producto en promocion con descuento, hasPromo debe ser true");

        return true;
    }


    private boolean validateProductDetail(ProductDetailDTO detailDTO) throws BadRequestException {

        Validator<ProductDetailDTO> validator = new ProductDetailValidator();
        ValidationResult result = validator.validate(detailDTO);

        if(!result.isValid()){
            throw new BadRequestException(result.getErrors().toString());
        }

        return true;
    }

}
