package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.*;
import com.desafio_1.demo.exceptions.*;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.User;
import com.desafio_1.demo.repositories.IProductRepository;
import com.desafio_1.demo.repositories.IUserRepository;
import com.desafio_1.demo.services.mappers.ProductListMapper;
import com.desafio_1.demo.services.mappers.ProductMapper;
import com.desafio_1.demo.services.mappers.ProductPromoCountMapper;
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
    public void addProduct(ProductRequestDTO product)
            throws UnhandledException,
            UserIdInvalidException,
            UserNotFoundException,
            ProductDateInvalidException,
            ProductDetailRequiredException,
            ProductCategoryInvalidException,
            ProductPriceInvalidException,
            ProductIdPostInvalidException,
            ProductDetailTypeRequiredException,
            ProductDetailNameRequiredException,
            ProductDetailBrandRequiredException,
            ProductDetailColorRequiredException,
            ProductDetailIdInvalidException,
            ProductDiscountInvalidException,
            ProductHasPromoNotTrueException {

        if(validateProduct(product) && validateProductDetail(product.getDetail())){
            productRepository.addProduct(ProductMapper.toModel(product));
        }

    }

    @Override
    public ProductResponseDTO findProductsByFollowedId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId<= 0)
            throw new UserIdInvalidException();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        ArrayList<User> followed = userRepository.findFollowedByUserId(userId, (a, b)->a.compareTo(b));

        List<Integer> usersId = followed.stream().map(User::getId).collect(Collectors.toList());

        ProductResponseDTO productsFollowed = ProductListMapper.toDTO(user, productRepository.findProductsByFollowedId(usersId, createComparatorDate(order)));

        return productsFollowed;
    }

    @Override
    public ProductPromoCountDTO findProductsPromoCountByUserId(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId <= 0)
            throw new UserIdInvalidException();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        ArrayList<Product> products = productRepository.findProductsPromoByUserId(userId, createComparatorDate(null));

        return ProductPromoCountMapper.toDTO(user, products.size());
    }

    @Override
    public ProductResponseDTO findProductsPromoByUserId(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId <= 0)
            throw new UserIdInvalidException();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        ArrayList<Product> products = productRepository.findProductsPromoByUserId(userId, createComparatorDate(null));

        return ProductListMapper.toDTO(user,products);
    }

    private Comparator<LocalDate> createComparatorDate(String order){
        Comparator<LocalDate> comparator = (a, b)->b.compareTo(a);

        if(order != null && order.equals("date_desc")){
            comparator = (a, b)->a.compareTo(b);
        }

        return comparator;
    }


    private boolean validateProduct(ProductRequestDTO product) throws UserIdInvalidException,
            UserNotFoundException, ProductDateInvalidException,
            ProductDetailRequiredException,
            ProductCategoryInvalidException,
            ProductPriceInvalidException,
            ProductIdPostInvalidException,
            UnhandledException, ProductDiscountInvalidException, ProductHasPromoNotTrueException {
        int userId = product.getUserId();

        if(userId<= 0)
            throw new UserIdInvalidException();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        if(product.getDate() == null)
            throw new ProductDateInvalidException();

        if(product.getDetail() == null)
            throw new ProductDetailRequiredException();

        if(product.getCategory() <= 0)
            throw new ProductCategoryInvalidException();

        if(product.getPrice() <= 0)
            throw new ProductPriceInvalidException();

        if(product.getIdPost() <= 0)
            throw new ProductIdPostInvalidException();

        if(product.isHasPromo() && product.getDiscount() <= 0)
            throw new ProductDiscountInvalidException();

        if(!product.isHasPromo() && product.getDiscount() > 0)
            throw new ProductHasPromoNotTrueException();

        return true;
    }

    private boolean validateProductDetail(ProductDetailDTO detailDTO) throws ProductDetailIdInvalidException,
            ProductDetailNameRequiredException,
            ProductDetailBrandRequiredException,
            ProductDetailColorRequiredException,
            ProductDetailTypeRequiredException
    {

        if(detailDTO.getProductId() <= 0)
            throw new ProductDetailIdInvalidException();

        if(detailDTO.getProductName().isBlank())
            throw new ProductDetailNameRequiredException();

        if(detailDTO.getBrand().isBlank())
            throw new ProductDetailBrandRequiredException();

        if(detailDTO.getColor().isBlank())
            throw new ProductDetailColorRequiredException();

        if(detailDTO.getType().isBlank())
            throw new ProductDetailTypeRequiredException();

        return true;
    }

}
