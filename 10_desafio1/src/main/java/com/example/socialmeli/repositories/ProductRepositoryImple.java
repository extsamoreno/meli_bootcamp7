package com.example.socialmeli.repositories;

import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImple implements ProductRepository{
    @Override
    public NewPostResponseDTO addPost(NewPostRequestDTO newPostRequestDTO) {
        return null;
    }
}
