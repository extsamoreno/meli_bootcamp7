package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.User;
import com.example.socialmeli.models.dtos.PostDTO;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImple implements ProductRepository{
    int count = 0;

    @Autowired
    UserRepository userRepository;

    @Override
    public NewPostResponseDTO addPost(NewPostRequestDTO newPostRequestDTO) throws InexistentUserException {
        User user = userRepository.getUserById(newPostRequestDTO.getUserId());
        PostDTO post = new PostDTO();
        NewPostResponseDTO newPost = new NewPostResponseDTO();

        post.setPostId(count);
        post.setUserId(user.getUserId());
        post.setDetail(newPostRequestDTO.getDetail());
        post.setCategory(newPostRequestDTO.getCategory());
        post.setDate(newPostRequestDTO.getDate());
        post.setPrice(newPostRequestDTO.getPrice());

        user.addPost(post);

        newPost.setPostId(count);
        newPost.setUserId(user.getUserId());

        count++;

        return newPost;
    }
}
