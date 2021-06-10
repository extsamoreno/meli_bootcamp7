package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.CategoryDoesntExistException;
import com.example.demo.exceptions.InvalidDateFormatException;
import com.example.demo.exceptions.ProductDontFoundException;
import com.example.demo.exceptions.UserDontFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface ProductService {
     void addProducts();
     NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO) throws ParseException, UserDontFoundException, ProductDontFoundException, CategoryDoesntExistException, InvalidDateFormatException;
     FollowedPostListResponseDTO getFollowedPostList(int userId, String order) throws InvalidDateFormatException;
     NewPostWithPromResponseDTO newPostWithProm(NewPostWithPromRequestDTO newPostWithPromRequestDTO) throws ParseException, UserDontFoundException, ProductDontFoundException, CategoryDoesntExistException, InvalidDateFormatException;
     PostWithPromCountDTO getPostsWithPromCount(int userId) throws UserDontFoundException;
     PostWithPromListResponseDTO getPostsWithPromList(int userId) throws UserDontFoundException, InvalidDateFormatException;
}
