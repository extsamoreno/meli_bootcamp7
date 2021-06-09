package com.example.desafio1.repository;

import com.example.desafio1.exception.ProductPostNotFoundException;
import com.example.desafio1.model.ProductPost;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductPostRepository implements IProductPostRepository{
    private HashMap<Integer, ProductPost> postDir = new HashMap<>();

    @Override
    public void createNewPost(ProductPost productPost) {
        postDir.put(productPost.getId_post(), productPost);
    }

    @Override
    public ProductPost getProductPostById(int postId) throws ProductPostNotFoundException {
        if(!postDir.containsKey(postId))
        {
            throw new ProductPostNotFoundException(postId);
        }else{
            return postDir.get(postId);
        }
    }

    @Override
    public boolean isUsedPostId(int productId) {
        return postDir.containsKey(productId);
    }

    //used ids are invalid
    @Override
    public int validPostId() {
        return postDir.size() + 1;
    }

    //Method for test queries only
    @Override
    public HashMap<Integer, ProductPost> getProductPostCatalog() {
        return postDir;
    }

}
