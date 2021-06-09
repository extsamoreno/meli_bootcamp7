package com.example.desafio_1.repository;

import com.example.desafio_1.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductRepository implements IProductRepository {

    private HashMap<Integer, Product> products;

    public ProductRepository() {
        this.products = new HashMap<>();
        add(new Product("Silla gamer", "Gamer", "Racer", "Red & Black", "Special Edition"));
        add(new Product("Macbook pro", "PC", "Mac", "Grey & Black", "2021 with touch bar"));
        add(new Product("MX master 3", "Oficina", "Logitech", "Black", ""));
        add(new Product("XBOX One Controller", "Gamer", "Microsoft", "Black", "Pro Edition"));
    }

    @Override
    public Product getById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    //Same logic in all the add's, maybe some generic and default implementation? :think:
    @Override
    public void add(Product product) {
        int newId = this.products.size() + 1;
        product.setId(newId);
        this.products.put(newId, product);
    }
}
