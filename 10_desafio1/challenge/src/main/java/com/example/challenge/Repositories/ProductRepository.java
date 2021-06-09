package com.example.challenge.Repositories;

import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Models.Post;
import com.example.challenge.Models.User;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public String addNewPost(Post post, User user) throws UserNotFoundException {
        if(user.addNewPost(post))
            return "Post added successfully";
        else
            return "Error adding Post";
    }
}
