package meli.springchallenge.repositories;

import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;

import java.util.List;

public interface IProductRepository {

    void createProduct (Product product) throws ProductIdNotValidException;

    void createPost (Post post) throws PostIdNotValidException;

    List<Post> getPostByUserId(int userId);

    Product getProductById(int productId);
}
