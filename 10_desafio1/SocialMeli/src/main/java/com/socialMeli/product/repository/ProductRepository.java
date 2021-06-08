package com.socialMeli.product.repository;

import com.socialMeli.product.exceptions.FailCreatePostException;
import com.socialMeli.product.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository implements iProductRepository {

    private HashMap<Integer, Post> posts;
    private AtomicInteger postId;

    @Override
    public void newPost(Post newPost) throws FailCreatePostException {
        try {
            this.posts.put(this.postId.getAndIncrement(), newPost);
        } catch (Exception e){
            throw new FailCreatePostException();
        }
    }
}
