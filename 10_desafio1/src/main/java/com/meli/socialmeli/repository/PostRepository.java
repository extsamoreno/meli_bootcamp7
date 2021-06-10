package com.meli.socialmeli.repository;

import com.meli.socialmeli.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostRepository {

    public static Map<Integer, Post> posts = new HashMap<>();

    public void insertNewPost(int postId, Post post) {
        posts.put(postId, post);
    }

    public boolean postIdAlreadyExists(int postId) {
        return posts.containsKey(postId);
    }

    public Map<Integer, Post> getPostsByMerchantId(int userId) {

        Map<Integer, Post> merchantPosts = new HashMap<>();

        for (Map.Entry<Integer, Post> entry : posts.entrySet()) {
            if (userId == entry.getValue().getUserId()) {
                merchantPosts.put(entry.getKey(), entry.getValue());
            }
        }
        return merchantPosts;
    }

    public int getNumberOfPostsById(int userId) {

        AtomicInteger promoProductsCount = new AtomicInteger();

        posts.forEach((k, v) -> {
            if (v.getUserId() == userId) {
                if (v.isHasPromo()) {
                    promoProductsCount.getAndIncrement();
                    {
                    }
                }
            }
        });
        return promoProductsCount.get();
    }

    public Map<Integer, Post> getPromoPostsById(int userId) {

        Map<Integer, Post> promoPosts = new HashMap<>();

        for (Map.Entry<Integer, Post> entry : posts.entrySet()) {

            if (entry.getValue().getUserId() == userId) {
                if (entry.getValue().isHasPromo()) {
                    promoPosts.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return promoPosts;
    }
}

