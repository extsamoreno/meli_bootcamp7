package com.example.SocialMeli.Repositories;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Models.Post;
import com.example.SocialMeli.Models.Product;
import com.example.SocialMeli.Models.User;

import java.util.List;

public interface iDataRepository {

    public User getUserByID(int userId) throws UserNotFoundException;
    public List<User> getUsersByIds(List<Integer> UserIds) throws UserNotFoundException;
    public List<Post> getPostsByIds(List<Integer> postIds) throws PostNotFoundException, ProductNotFoundException;
    public Post getPostByID(int postId) throws PostNotFoundException;
    public Product getProductByID(int productId) throws ProductNotFoundException;
    public List<Post> getPosts();
    public List<Product> getProducts();

}
