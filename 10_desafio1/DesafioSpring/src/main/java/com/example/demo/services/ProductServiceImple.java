package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.CategoryDoesntExistException;
import com.example.demo.exceptions.InvalidDateFormatException;
import com.example.demo.exceptions.ProductDontFoundException;
import com.example.demo.exceptions.UserDontFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repositories.CategoryRepositoryImple;
import com.example.demo.repositories.ProductRepositoryImple;
import com.example.demo.repositories.UserRepositoryImple;
import com.example.demo.services.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ProductServiceImple implements  ProductService{

    @Autowired
    ProductRepositoryImple productRepositoryImple;
    @Autowired
    UserRepositoryImple userRepositoryImple;
    @Autowired
    CategoryRepositoryImple categoryRepositoryImple;

    @Override
    public void addProducts() {
        productRepositoryImple.addProducts();
    }

    @Override
    public NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO) throws ParseException, UserDontFoundException, ProductDontFoundException, CategoryDoesntExistException, InvalidDateFormatException {
        NewPostResponseDTO newPostResponseDTO;
        User user = userRepositoryImple.findUserById(newPostRequestDTO.getUserId());
        Product product = productRepositoryImple.findProductById(newPostRequestDTO.getDetail().getProduct_id());
        Category category = categoryRepositoryImple.findCategoryById(newPostRequestDTO.getCategory());

        if(user == null){
            throw new UserDontFoundException(newPostRequestDTO.getUserId());
        }else if(product == null || !product.equals(ProductMapper.toProduct(newPostRequestDTO.getDetail()))){
            throw new ProductDontFoundException(newPostRequestDTO.getDetail().getProduct_id());
        }else if(category == null){
            throw new CategoryDoesntExistException(newPostRequestDTO.getCategory());
        }else {
            newPostResponseDTO = userRepositoryImple.newPost(newPostRequestDTO, category);
        }

        return newPostResponseDTO;
    }

    @Override
    public FollowedPostListResponseDTO getFollowedPostList(int userId, String order) throws InvalidDateFormatException {
        User user = userRepositoryImple.findUserById(userId);
        FollowedPostListResponseDTO followedPostListResponseDTO=null;
        if(user !=null){
            followedPostListResponseDTO = userRepositoryImple.getFollowedPostList(userId,order);
        }else{

        }
        return followedPostListResponseDTO;
    }

    @Override
    public NewPostWithPromResponseDTO newPostWithProm(NewPostWithPromRequestDTO newPostWithPromRequestDTO) throws ParseException, UserDontFoundException, ProductDontFoundException, CategoryDoesntExistException, InvalidDateFormatException {
        NewPostWithPromResponseDTO newPostWithPromResponseDTO;
        User user = userRepositoryImple.findUserById(newPostWithPromRequestDTO.getUserId());
        Product product = productRepositoryImple.findProductById(newPostWithPromRequestDTO.getDetail().getProduct_id());
        Category category = categoryRepositoryImple.findCategoryById(newPostWithPromRequestDTO.getCategory());

        if(user == null){
            throw new UserDontFoundException(newPostWithPromRequestDTO.getUserId());
        }else if(product == null){
            throw new ProductDontFoundException(newPostWithPromRequestDTO.getDetail().getProduct_id());
        }else if(category == null){
            throw new CategoryDoesntExistException(newPostWithPromRequestDTO.getCategory());
        }else {
            newPostWithPromResponseDTO = userRepositoryImple.newPostWithProm(newPostWithPromRequestDTO, category);
        }

        return newPostWithPromResponseDTO;
    }

    @Override
    public PostWithPromCountDTO getPostsWithPromCount(int userId) throws UserDontFoundException {
        PostWithPromCountDTO postWithPromCountDTO;
        User user = userRepositoryImple.findUserById(userId);
        if(user == null){
            throw new UserDontFoundException(userId);
        }else{
            postWithPromCountDTO = userRepositoryImple.getProductsWithPromCount(userId);
        }
        return postWithPromCountDTO;
    }

    @Override
    public PostWithPromListResponseDTO getPostsWithPromList(int userId) throws UserDontFoundException, InvalidDateFormatException {
        PostWithPromListResponseDTO postWithPromListResponseDTO;
        User user = userRepositoryImple.findUserById(userId);
        if(user == null){
            throw new UserDontFoundException(userId);
        }else{
            postWithPromListResponseDTO = userRepositoryImple.getPostWithPromList(userId);
        }
        return postWithPromListResponseDTO;
    }


}
