package com.example.desafio1.repository;

import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    public boolean isProductInCatalog(Product product) {
        Collection<Product> products = catalog.values();
        List<Product> match= products.stream()
                .filter(prod -> prod.getBrand().equals(product.getBrand()))
                .filter(prod -> prod.getType().equalsIgnoreCase(product.getType()))
                .filter(prod -> prod.getProductName().equalsIgnoreCase(product.getProductName()))
                .collect(Collectors.toList());
        return match.size() != 0;
    }

    @Override
    public int getProductId(Product product) {
        int id = 0;
        Collection<Product> products = catalog.values();
        Product match= products.stream()
                .filter(prod -> prod.getBrand().equals(product.getBrand()))
                .filter(prod -> prod.getType().equalsIgnoreCase(product.getType()))
                .filter(prod -> prod.getProductName().equalsIgnoreCase(product.getProductName()))
                .findFirst()
                .get();

        id = match.getProduct_id();

        return id;
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
