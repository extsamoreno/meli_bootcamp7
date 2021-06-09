package com.example.DesafioSpring.repositories;

import com.example.DesafioSpring.dto.*;
import com.example.DesafioSpring.exceptions.*;
import com.example.DesafioSpring.models.Post;
import com.example.DesafioSpring.models.Product;
import com.example.DesafioSpring.models.User;

import java.util.List;

public interface IUserRepository {
    public List<User> getUsersByIds(List<Integer> UserIds) throws UserNotFoundException;

    public List<Post> getPostsByIds(List<Integer> postIds) throws PostNotFoundException, ProductNotFoundException;
    public Post getPostByID(int postId) throws PostNotFoundException;
    public List<Post> getPosts();
    public Product getProductByID(int productId) throws ProductNotFoundException;

    public List<User> getUsers();

    public List<Product> getProducts();

    public User getUserByID(int userId) throws UserNotFoundException;
}
