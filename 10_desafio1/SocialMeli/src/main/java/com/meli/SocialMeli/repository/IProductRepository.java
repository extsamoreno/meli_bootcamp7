package com.meli.SocialMeli.repository;

import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;

import java.util.ArrayList;

public interface IProductRepository {
    public void newPost(Post post);

    public int newProduct(Product product);

    ArrayList<Post> getPostByUser(int userId);

    Product getProductById(int productId);

    ArrayList<Post> getPromoPostByUser(int userId);
}
