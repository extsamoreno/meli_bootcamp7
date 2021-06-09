package meli.springchallenge.repositories;

import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;

import java.util.List;

public interface IProductRepository {

    void createProduct (Product product);

    void createPost (Post post);

    List<Post> getPostByUserId(int userId);

    Product getProductById(int productId);
}
