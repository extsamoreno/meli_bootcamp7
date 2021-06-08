package com.example.desafio1.repositories;

import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public String addNewPost(int userId, Post post, User user) throws InvalidUserIdException {
        user.addNewPost(post);
        return "Se ha agregado el producto con id: " + post.getDetail().getProduct_id() +
                " al usuario con id: " + userId;
    }
}
