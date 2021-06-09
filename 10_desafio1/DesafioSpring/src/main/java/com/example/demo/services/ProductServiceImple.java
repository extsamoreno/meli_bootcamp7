package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.NewPostRequestDTO;
import com.example.demo.dtos.NewPostResponseDTO;
import com.example.demo.exceptions.CategoryDoesntExistException;
import com.example.demo.exceptions.ProductDoesntExistException;
import com.example.demo.exceptions.UserDoesntExistException;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repositories.CategoryRepositoryImple;
import com.example.demo.repositories.ProductRepositoryImple;
import com.example.demo.repositories.UserRepositoryImple;
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
    public NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO) throws ParseException, UserDoesntExistException, ProductDoesntExistException, CategoryDoesntExistException {
        NewPostResponseDTO newPostResponseDTO=null;
        User user = userRepositoryImple.findUserById(newPostRequestDTO.getUserId());
        Product product = productRepositoryImple.findProductById(newPostRequestDTO.getDetail().getProduct_id());
        Category category = categoryRepositoryImple.findCategoryById(newPostRequestDTO.getCategory());

        if(user == null){
            throw new UserDoesntExistException(newPostRequestDTO.getUserId());
        }else if(product == null){
            throw new ProductDoesntExistException(newPostRequestDTO.getDetail().getProduct_id());
        }else if(category == null){
            throw new CategoryDoesntExistException(newPostRequestDTO.getCategory());
        }else {
            newPostResponseDTO = userRepositoryImple.newPost(newPostRequestDTO, category);
        }

        return newPostResponseDTO;
    }

    @Override
    public FollowedPostListResponseDTO getFollowedPostList(int userId, String order) {
        User user = userRepositoryImple.findUserById(userId);
        FollowedPostListResponseDTO followedPostListResponseDTO=null;
        if(user !=null){
            followedPostListResponseDTO = userRepositoryImple.getFollowedPostList(userId,order);
        }
        return followedPostListResponseDTO;
    }


}
