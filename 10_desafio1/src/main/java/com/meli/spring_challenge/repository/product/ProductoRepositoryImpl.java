package com.meli.spring_challenge.repository.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.model.Product;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductoRepositoryImpl implements  ProductRepository{

    private final String jsonPath = "classpath:products.json";
    List<Product> productList;


    @Override
    public Product findProductByID(int productID) {
        return this.productList.stream()
                .filter(product -> product.getProductID() == productID)
                .findFirst()
                .orElse(null);
    }

    private List<Product> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile(jsonPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<Product>> typeDef = new TypeReference<>(){};
        List<Product> productList = null;
        try{
            productList = om.readValue(file,typeDef);
        } catch (IOException e) {
            throw new RuntimeException("Impossible to open JSON file", e);
        }

        return productList;
    }

    private void writeDataBase(Follow follow) {
        JSONArray productsArray = new JSONArray(this.productList);
        JSONObject productJson = new JSONObject(follow);
        productsArray.put(productJson);

        try(FileWriter writer = new FileWriter(jsonPath)) {
            writer.write(productsArray.toString());
            writer.flush();
        } catch(IOException e) {
            throw new RuntimeException("Impossible to write on JSON file", e);
        }

    }
}
