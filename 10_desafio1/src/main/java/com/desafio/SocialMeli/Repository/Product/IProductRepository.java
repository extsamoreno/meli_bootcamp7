package com.desafio.SocialMeli.Repository.Product;

import com.desafio.SocialMeli.Model.Product;

import java.util.List;

public interface IProductRepository {
    Product getProductById(int product_id);

    List<Product> getAllProducts();

    void saveProduct (Product product);

}
