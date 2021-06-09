package com.example.desafio1.repository;

import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository implements IProductRepository{
    private HashMap<Integer, Product> catalog = new HashMap<>();


    @Override
    public void createProduct(Product product) {
       catalog.put(product.getProduct_id(), product);
    }

    @Override
    public boolean isUsedId(int productId) {
        return catalog.containsKey(productId);
    }

    //used ids are invalid
    @Override
    public int validId() {
        return catalog.size() + 1;
    }

    //Method for test queries only
    @Override
    public HashMap<Integer, Product> getProductCatalog() {
        return catalog;
    }


    @Override
    public Product getProductById(int productId) throws ProductNotFoundException {
        if(!catalog.containsKey(productId))
        {
            throw new ProductNotFoundException(productId);
        }else{
            return catalog.get(productId);
        }
    }
}
