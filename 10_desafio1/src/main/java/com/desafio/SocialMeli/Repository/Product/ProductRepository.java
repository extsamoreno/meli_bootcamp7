package com.desafio.SocialMeli.Repository.Product;

import com.desafio.SocialMeli.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    List<Product> productList = new ArrayList<>();

    @Override
    public Product getProductById(int product_id) {
        return productList.stream().filter(product -> product.getProduct_id() == product_id).findFirst().orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        productList.add(product);
    }

}
