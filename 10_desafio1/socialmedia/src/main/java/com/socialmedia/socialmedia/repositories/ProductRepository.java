package com.socialmedia.socialmedia.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public int addNewProduct(Product product) {
        var results = loadDatabaseProducts();
        int newId = results.size()+1;
        product.setId(newId);

        results.add(product);

        updateDatabaseProducts(results);

        return newId;
    }

    @Override
    public int addNewPost(Post post) {
        var results = loadDatabasePosts();
        int newId = results.size()+1;
        post.setId(newId);

        results.add(post);

        updateDatabasePosts(results);

        return newId;
    }

    @Override
    public List<Post> getPostsByUser(int id) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -14);
        Date twoWeeks = c.getTime();

        List<Post> postsByUser = loadDatabasePosts()
                .stream()
                .filter(post -> post.getUserId() == id && !post.getDate().before(twoWeeks))
                .collect(Collectors.toList());

        return postsByUser;
    }

    private List<Product> loadDatabaseProducts() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:products.json");
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

    private List<Post> loadDatabasePosts() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Post>> typeReference = new TypeReference<>() {
        };
        List<Post> posts = null;
        try {
            posts = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return posts;
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

    private void updateDatabasePosts(List<Post> posts) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(posts);

            FileWriter myWriter = new FileWriter("src/main/resources/posts.json", false);
            myWriter.write(jsonString);
            myWriter.close();

        } catch (Exception ex) {
            System.out.println("Error al convertir a json");
            ex.printStackTrace();
        }
    }
}
