package com.example.desafio1.repositories;

import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public void addNewPost(User user, Post post) {
        user.addNewPost(post);
    }
}
