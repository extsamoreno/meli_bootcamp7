package com.socialmedia.socialmedia.repositories;

import com.socialmedia.socialmedia.repositories.entities.Post;
import com.socialmedia.socialmedia.repositories.entities.Product;

import java.util.List;

public interface IProductRepository {
    int addNewProduct(Product product);

    int addNewPost(Post post);

    List<Post> getPostsByUser(int id);
}
