package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.PostDTO;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.request.NewPromoPostRequestDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedPostsResponseDTO;
import com.example.socialmeli.models.dtos.response.ListSellerPromoProductsDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import com.example.socialmeli.models.dtos.response.SellerPromoProductsCountResponseDTO;
import com.example.socialmeli.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;

@Service
public class ProductServiceImple implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public NewPostResponseDTO addPost(NewPostRequestDTO newPostRequestDTO) throws InexistentUserException, ExistentPostException {
        productRepository.addPost(newPostRequestDTO);

        NewPostResponseDTO response = new NewPostResponseDTO(200,"Se ha agregado un nuevo producto al repositorio");

        return response;
    }

    @Override
    public ListFollowedPostsResponseDTO listPosts(int idUser, String order) throws InexistentUserException, InexistentDateOrderException {
        if(!order.matches("date_asc|date_desc")){
            throw new InexistentDateOrderException(order);
        }

        ListFollowedPostsResponseDTO posts = productRepository.listPosts(idUser);

        switch (order) {
            case "date_asc":
                posts.getPosts().sort(Comparator.comparing(PostDTO::getDate));
                break;
            case "date_desc":
                posts.getPosts().sort(Comparator.comparing(PostDTO::getDate));
                Collections.reverse(posts.getPosts());
                break;
        }

        return posts;
    }

    @Override
    public NewPostResponseDTO addPromoPost(NewPromoPostRequestDTO newPromoPostRequestDTO) throws InexistentUserException, ExistentPromoPostException, InvalidPromoPostException {
        if(!newPromoPostRequestDTO.isHasPromo()){
            throw new InvalidPromoPostException();
        }

        productRepository.addPromoPost(newPromoPostRequestDTO);

        NewPostResponseDTO response = new NewPostResponseDTO(200,"Se ha agregado un nuevo producto en promoción al repositorio");


        return response;
    }

    @Override
    public SellerPromoProductsCountResponseDTO countPromoProducts(int userId) throws InexistentUserException{
        SellerPromoProductsCountResponseDTO promoProductsCount = productRepository.countPromoProducts(userId);

        return promoProductsCount;
    }

    @Override
    public ListSellerPromoProductsDTO listPromoProducts(int userId) throws InexistentUserException {
        ListSellerPromoProductsDTO promoProducts = productRepository.listPromoProducts(userId);

        return promoProducts;
    }

}
