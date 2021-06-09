package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedPostsResponseDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
    NewPostResponseDTO addPost(NewPostRequestDTO newPostRequestDTO) throws InexistentUserException;
    ListFollowedPostsResponseDTO listPosts(int idUser) throws InexistentUserException;
}
