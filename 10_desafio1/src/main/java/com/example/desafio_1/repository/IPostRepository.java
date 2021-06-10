package com.example.desafio_1.repository;

import com.example.desafio_1.models.Post;

import java.util.List;

public interface IPostRepository extends IRepository<Post> {

    List<Post> getAllPostsBeforeTwoWeeksFromSellerId(int sellerId);

    List<Post> getAllPostInPromoFromUserId(int userId);
}
