package meli.springchallenge.repositories;

import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;

import java.util.List;

public interface IProductRepository {

    void createProduct (Product product) throws ProductIdNotValidException;

    void createPost (Post post) throws PostIdNotValidException;

    Post getPostById(int userId);

    List<Post> getPostsByUserId(int userId);

    Product getProductById(int productId);

    void deleteProduct(int productId);

    void deletePost(int postId);
}
