package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    NewPostResponseDTO addPost(NewPostRequestDTO newPostRequestDTO) throws InexistentUserException;
}
