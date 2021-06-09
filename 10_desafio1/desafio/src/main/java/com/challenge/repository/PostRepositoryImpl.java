package com.challenge.repository;

import com.challenge.entity.Post;
import com.challenge.entity.Product;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private List<Product> productList;
    private List<Post> postList;

    @PostConstruct
    private void init() {
        this.productList = loadProductList();
        this.postList = loadPostList();
    }

    @Override
    public void addNewProduct(Post post) throws PostIdAlreadyExistsException, IOException {

        Optional<Post> contains = postList.stream().filter(p -> p.getPostId().equals(post.getPostId())).findAny();
        if (!contains.isPresent()) {
            this.postList.add(post);
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/posts.json"), this.postList);
        } else {
            throw new PostIdAlreadyExistsException();
        }
    }

    private List<Post> loadPostList() {
        File file = null;
        try {
            //TODO change the absolute path to the classpath (now used to keep data upon re-compile)
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        TypeReference<List<Post>> typeRef = new TypeReference<>() {
        };
        List<Post> posts = null;

        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts;
    }

    private List<Product> loadProductList() {
        File file = null;
        try {
            //TODO change the absolute path to the classpath (now used to keep data upon re-compile)
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/products.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        TypeReference<List<Product>> typeRef = new TypeReference<>() {};
        List<Product> products = null;

        try {
            products = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}
