package com.example.desafio1.repository;

import com.example.desafio1.exception.ProductPostNotFoundException;
import com.example.desafio1.model.ProductPost;

import java.util.HashMap;
import java.util.List;

public interface IProductPostRepository {
    void createNewPost(ProductPost productPost);
    ProductPost getProductPostById(int postId) throws ProductPostNotFoundException;
    boolean isUsedPostId(int postId);
    int validPostId();

    HashMap<Integer, ProductPost> getProductPostCatalog();

    //ArrayList<ProductPost> getRecentOrderedPosts(int followedUserId);
    List<ProductPost> getRecentPosts(int followedUserId);
}
