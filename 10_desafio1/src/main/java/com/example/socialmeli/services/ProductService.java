package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.request.NewPromoPostRequestDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedPostsResponseDTO;
import com.example.socialmeli.models.dtos.response.ListSellerPromoProductsDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import com.example.socialmeli.models.dtos.response.SellerPromoProductsCountResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    NewPostResponseDTO addPost(NewPostRequestDTO newPostRequestDTO) throws InexistentUserException, ExistentPostException, InvalidDatePostException;
    ListFollowedPostsResponseDTO listPosts( int idUser, String order) throws InexistentUserException, InexistentDateOrderException;
    NewPostResponseDTO addPromoPost(NewPromoPostRequestDTO newPromoPostRequestDTO) throws InexistentUserException, ExistentPromoPostException, InvalidPromoPostException, InvalidDatePostException;
    SellerPromoProductsCountResponseDTO countPromoProducts(int userId) throws InexistentUserException;
    ListSellerPromoProductsDTO listPromoProducts(int userId) throws InexistentUserException;
}
