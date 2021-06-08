package com.example.socialmeli.repository;

import com.example.socialmeli.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProducRepository implements IProductRepository {

    List<Product> products = new ArrayList<>();
    int cont = 1;

    @Override
    public Product addProduct(Product obj) {
        obj.setProduct_id(cont++);
        products.add(obj);
        return obj;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
