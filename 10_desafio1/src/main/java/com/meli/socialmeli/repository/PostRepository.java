package com.meli.socialmeli.repository;

import com.meli.socialmeli.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostRepository {

    public static Map<Integer, Post> posts = new HashMap<>();

    /**
     * Inserts a new post (this post can be promo or standard)
     *
     * @param postId Corresponding to the Id of the Post to be inserted
     * @param post   The Post to be inserted
     */
    public void insertNewPost(int postId, Post post) {
        posts.put(postId, post);
    }

    /**
     * Checks if there is already a Post with the entered Id entered
     *
     * @param postId The Id of the Post to be verified
     * @return True if there is already a Post with that same Id
     */
    public boolean postIdAlreadyExists(int postId) {
        return posts.containsKey(postId);
    }

    /**
     * Obtains all the posts of a specific user
     *
     * @param userId Corresponding to the user from whom you want to obtain the Posts
     * @return The posts of a specific user
     */
    public Map<Integer, Post> getPostsByMerchantId(int userId) {

        Map<Integer, Post> merchantPosts = new HashMap<>();

        posts.forEach((k, v) -> {
            if (v.getUserId() == userId) {
                merchantPosts.put(k, v);
            }
        });

        return merchantPosts;
    }

    /**
     * Obtains a counter with the number of promo posts of a specific user
     *
     * @param userId Corresponding to the user from whom you want to obtain the Posts counter
     * @return The number of posts of a specific user
     */
    public int getNumberOfPromoPostsById(int userId) {

        AtomicInteger promoProductsCount = new AtomicInteger();

        posts.forEach((k, v) -> {
            if (v.getUserId() == userId) {
                if (v.isHasPromo()) {
                    promoProductsCount.getAndIncrement();
                }
            }
        });
        return promoProductsCount.get();
    }

    /**
     * Obtains the promo posts of a specific user
     *
     * @param userId Corresponding to the user from whom you want to obtain the promo Posts
     * @return The promo posts of a specific user
     */
    public Map<Integer, Post> getPromoPostsById(int userId) {

        Map<Integer, Post> promoPosts = new HashMap<>();

        posts.forEach((k, v) -> {
            if (v.getUserId() == userId) {
                if (v.isHasPromo()) {
                    promoPosts.put(k, v);
                }
            }
        });
        return promoPosts;
    }
}

