package com.meli.socialmeli.repository;

import com.meli.socialmeli.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository {

    private static Map<Integer, Post> posts = new HashMap<>();

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
}
