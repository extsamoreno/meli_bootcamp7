package com.bootcamp.desafio1.repository.product;


import com.bootcamp.desafio1.exception.PostNotFoundException;
import com.bootcamp.desafio1.exception.ProductAlreadyExistsException;
import com.bootcamp.desafio1.exception.ProductNotFoundException;
import com.bootcamp.desafio1.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    // Product Data Base
    private HashMap<Integer, Product> productDB = loadDateBase();


    public HashMap<Integer, Product> loadDateBase(){
        HashMap<Integer, Product> productDB = new HashMap<>();
        ArrayList<Product> productsList = readDateBase();
        for(Product x :  productsList){
            productDB.put(x.getProductId(), x);
        }
        return productDB;
    }


    // Method to Read the data from JSON to List of Products called productsList
    public ArrayList<Product> readDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:products.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<ArrayList<Product>> typeDef = new TypeReference<>() {
        };
        ArrayList<Product> productsList = null;
        try {
            productsList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productsList;
    }


    @Override
    public boolean productIdExists(int productId) {
        // Validate that the productId is in the Data Base
        if(productDB.containsKey(productId))
            return true;
        else
            return false;
    }


    @Override
    public Product getProductById(int productId) throws ProductNotFoundException {
        // Validate that the postId is in the Data Base
        if( productIdExists(productId) )
            return  productDB.get(productId);
        else
            throw new ProductNotFoundException(productId);
    }

    @Override
    public void addProductInDB(Product product) throws ProductAlreadyExistsException {
        int productId = product.getProductId();

        // Validate that the productId is not in the productsDB
        if( productDB.containsKey(productId) )
            throw new ProductAlreadyExistsException(productId);
        else
            productDB.put(productId, product);
    }
}
