package com.socialmedia.socialmedia.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia.socialmedia.exceptions.ObjectNotFoundException;
import com.socialmedia.socialmedia.repositories.entities.Follower;
import com.socialmedia.socialmedia.repositories.entities.Post;
import com.socialmedia.socialmedia.repositories.entities.Product;
import com.socialmedia.socialmedia.repositories.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository {
    private List<Product> loadDatabaseProducts() {
        File file = null;

        try {
            file = ResourceUtils.getFile("src/main/resources/products.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Product>> typeReference = new TypeReference<>() {
        };
        List<Product> products = null;
        try {
            products = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return products;
    }

    private void updateDatabaseProducts(List<Product> products) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(products);

            FileWriter myWriter = new FileWriter("src/main/resources/products.json", false);
            myWriter.write(jsonString);
            myWriter.close();

        } catch (Exception ex) {
            System.out.println("Error al convertir a json");
            ex.printStackTrace();
        }
    }

    @Override
    public int add(Product object) {
        List<Product> products = loadDatabaseProducts();
        int newId = products.size() + 1;

        object.setId(newId);

        products.add(object);

        updateDatabaseProducts(products);

        return newId;
    }

    @Override
    public Product update(Product object) throws ObjectNotFoundException {
        List<Product> products = loadDatabaseProducts();

        Product productTemp = getById(object.getId());

        products.set(products.indexOf(productTemp), object);

        updateDatabaseProducts(products);

        return object;
    }

    @Override
    public Product getById(int id) {
        List<Product> products = loadDatabaseProducts();

        Optional<Product> result = products.stream()
                .filter(follower -> follower.getId() == id)
                .findFirst();

        if (!result.isPresent()) return null;

        return result.get();
    }
}
