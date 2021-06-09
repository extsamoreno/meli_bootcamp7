package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.InexistentDateOrderException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.PostDTO;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedPostsResponseDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
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
    public NewPostResponseDTO addPost(NewPostRequestDTO newPostRequestDTO) throws InexistentUserException {
        NewPostResponseDTO newPost = productRepository.addPost(newPostRequestDTO);

        return newPost;
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
                Collections.sort(posts.getPosts(), Collections.reverseOrder());
                break;
        }

        return posts;
    }

}
