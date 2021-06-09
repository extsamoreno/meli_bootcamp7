package com.example.desafio1.repository;

import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.post.PostNotFoundException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.User;

import java.text.ParseException;
import java.util.ArrayList;

public interface iPostRepository {

    Post savePost(Post post) throws PostAlreadyExistException, UserNotFoundException;
    //Post findPostById(Integer id) throws PostNotFoundException;
    ArrayList<Post> findPostsByUserId(Integer id) throws UserNotFoundException;
}
