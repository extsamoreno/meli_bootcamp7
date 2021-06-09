package com.example.desafio1.repositories;

import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;

public interface IProductRepository {
    String addNewPost(User user, Post post) throws InvalidUserIdException;
}
