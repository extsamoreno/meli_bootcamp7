package com.meli.SocialMeli.repository;

import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepository implements IProductRepository{

    @Override
    public void newPost(Post post) {
        Tables.newPost(post);
    }

    @Override
    public int newProduct(Product product) {
        return Tables.newProduct(product);
    }

    @Override
    public ArrayList<Post> getPostByUser(int userId) {
        return Tables.getPostByUser(userId);
    }

    @Override
    public Product getProductById(int productId) {
        return Tables.getProductById(productId);
    }
}
