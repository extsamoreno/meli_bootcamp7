package com.example.demo.project.repository;

import com.example.demo.project.models.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository implements IProductRepository{

    private HashMap<Integer, Product> products;
    private Integer id;


    public ProductRepository(){
        this.products = new HashMap<>();
        this.id = 0;
    }


    @Override
    public Product getById(Integer id) {
        return this.products.get(id);
    }

    @Override
    public void addProduct(Product toProduct) {
        this.products.put(id++,toProduct);

    }
}
