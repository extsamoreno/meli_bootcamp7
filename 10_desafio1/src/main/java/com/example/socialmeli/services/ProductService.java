package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.ExistentPostException;
import com.example.socialmeli.exceptions.ExistentPromoPostException;
import com.example.socialmeli.exceptions.InexistentDateOrderException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.PostDTO;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.request.NewPromoPostRequestDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedPostsResponseDTO;
import com.example.socialmeli.models.dtos.response.ListSellerPromoProductsDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import com.example.socialmeli.models.dtos.response.SellerPromoProductsCountResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    String addPost(PostDTO newPostRequestDTO) throws InexistentUserException, ExistentPostException;
    ListFollowedPostsResponseDTO listPosts( int idUser, String order) throws InexistentUserException, InexistentDateOrderException;
    String addPromoPost(NewPromoPostRequestDTO newPromoPostRequestDTO) throws InexistentUserException, ExistentPromoPostException;
    SellerPromoProductsCountResponseDTO countPromoProducts(int userId) throws InexistentUserException;
    ListSellerPromoProductsDTO listPromoProducts(int userId) throws InexistentUserException;
}
