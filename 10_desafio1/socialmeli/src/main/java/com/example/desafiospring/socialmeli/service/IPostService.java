package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.service.DTO.PostDTO;
import com.example.desafiospring.socialmeli.service.DTO.PostListDTO;

//import com.example.desafiospring.socialmeli.exception.DateIsNotValidException;
//import com.example.desafiospring.socialmeli.exception.PostIdAlreadyExistException;
//import java.text.ParseException;
//import.java.util.list;

public interface IPostService {
    public void newPost(PostDTO post) throws UserNotFoundException;

    public PostListDTO getFollowedPostList(int userId) throws UserNotFoundException;

    Object getProductPost(Integer userId);
}
