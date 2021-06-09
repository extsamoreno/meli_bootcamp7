package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.NewPostRequestDTO;
import com.example.demo.dtos.NewPostResponseDTO;
import com.example.demo.exceptions.CategoryDoesntExistException;
import com.example.demo.exceptions.ProductDoesntExistException;
import com.example.demo.exceptions.UserDoesntExistException;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface ProductService {

     void addProducts();
     NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO) throws ParseException, UserDoesntExistException, ProductDoesntExistException, CategoryDoesntExistException;
     FollowedPostListResponseDTO getFollowedPostList(int userId, String order);
}
