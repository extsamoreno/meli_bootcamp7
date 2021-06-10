package com.example.desafio1.repositories;

import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;

public interface IProductRepository {
    void addNewPost(User user, Post post);
}
