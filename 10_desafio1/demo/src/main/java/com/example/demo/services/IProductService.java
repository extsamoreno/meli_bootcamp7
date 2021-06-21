package com.example.demo.services;

import com.example.demo.model.DTO.CountPromoDTO;
import com.example.demo.model.DTO.UserPostsDTO;
import com.example.demo.model.Post;

import java.util.Date;

public interface IProductService {

    Post newPost(int userId, int idPost, Date date, int productId, String productName, String type, String brand, String color, String notes, int category, double price);

    UserPostsDTO getPostsFromFollowed(int userId);

    UserPostsDTO getOrderedPosts(int userId, String order);

}
