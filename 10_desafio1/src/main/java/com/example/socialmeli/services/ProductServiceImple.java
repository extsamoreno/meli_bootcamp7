package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.PostDTO;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import com.example.socialmeli.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImple implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public NewPostResponseDTO addPost(NewPostRequestDTO newPostRequestDTO) throws InexistentUserException {
        NewPostResponseDTO newPost = productRepository.addPost(newPostRequestDTO);

        return newPost;
    }
}
