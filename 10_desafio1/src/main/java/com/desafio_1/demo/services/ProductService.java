package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.ProductDetailDTO;
import com.desafio_1.demo.dtos.ProductFollowedDTO;
import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.exceptions.*;
import com.desafio_1.demo.models.User;
import com.desafio_1.demo.repositories.IProductRepository;
import com.desafio_1.demo.repositories.IUserRepository;
import com.desafio_1.demo.services.mappers.ProductFollowedMapper;
import com.desafio_1.demo.services.mappers.ProductMapper;
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
    public ProductResponseDTO addProduct(ProductRequestDTO product)
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
            ProductDetailIdInvalidException
    {
        ProductResponseDTO productResponse = null;
        if(validateProduct(product) && validateProductDetail(product.getDetail())){
            productResponse = ProductMapper.toDTO(productRepository.addProduct(ProductMapper.toModel(product)));
        }

        return productResponse;
    }

    @Override
    public ProductFollowedDTO findProductsByFollowedId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId<= 0)
            throw new UserIdInvalidException();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        ArrayList<User> followed = userRepository.findFollowedByUserId(userId, (a, b)->a.compareTo(b));

        List<Integer> usersId = followed.stream().map(User::getId).collect(Collectors.toList());

        Comparator<LocalDate> comparator = (a, b)->b.compareTo(a);

        if(order != null && order.equals("date_desc")){
            comparator = (a, b)->a.compareTo(b);
        }

        ProductFollowedDTO productsFollowed = ProductFollowedMapper.toDTO(userId, productRepository.findProductsByFollowedId(usersId, comparator));

        return productsFollowed;
    }

    private boolean validateProduct(ProductRequestDTO product) throws UserIdInvalidException,
            UserNotFoundException, ProductDateInvalidException,
            ProductDetailRequiredException,
            ProductCategoryInvalidException,
            ProductPriceInvalidException,
            ProductIdPostInvalidException,
            UnhandledException
    {
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

        return true;
    }

    private boolean validateProductDetail(ProductDetailDTO detailDTO) throws ProductDetailIdInvalidException,
            ProductDetailNameRequiredException,
            ProductDetailBrandRequiredException,
            ProductDetailColorRequiredException,
            ProductDetailTypeRequiredException
    {

        if(detailDTO.getProduct_id() <= 0)
            throw new ProductDetailIdInvalidException();

        if(detailDTO.getProductName().equals(""))
            throw new ProductDetailNameRequiredException();

        if(detailDTO.getBrand().equals(""))
            throw new ProductDetailBrandRequiredException();

        if(detailDTO.getColor().equals(""))
            throw new ProductDetailColorRequiredException();

        if(detailDTO.getType().equals(""))
            throw new ProductDetailTypeRequiredException();

        return true;
    }
}
