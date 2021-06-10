package com.example.SocialMeli.Repositories;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Models.Post;
import com.example.SocialMeli.Models.Product;
import com.example.SocialMeli.Models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DataRepository implements iDataRepository {

    private List<User> users= this.loadDataBase();
    private List<Post> posts= new ArrayList<>();
    private List<Product> products= new ArrayList<>();

    public List<Post> getPosts() {
        return this.posts;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public List<User> getUsersByIds(List<Integer> UserIds) throws UserNotFoundException {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < UserIds.size(); i++) {
            User user = this.getUserByID(UserIds.get(i));
            users.add(user);
        }
        return users;

    }

    public List<Post> getPostsByIds(List<Integer> postIds) throws PostNotFoundException, ProductNotFoundException {

        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < postIds.size(); i++) {
            Post post = this.getPostByID(postIds.get(i));
            posts.add(post);
        }
        return posts;

    }

    private int findPostIndexByID(int postId) throws PostNotFoundException {

        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == postId ){
                return i;
            }
        }
        throw new PostNotFoundException(postId);
    }
    public Post getPostByID(int postId) throws PostNotFoundException {

        return posts.get(this.findPostIndexByID(postId));
    }
    private int findProductIndexByID(int productId) throws ProductNotFoundException{

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId ){
                return i;
            }
        }
        throw new ProductNotFoundException(productId);
    }
    public Product getProductByID(int productId) throws ProductNotFoundException {

        return products.get(this.findProductIndexByID(productId));
    }


    public int findUserIndexByID(int userId) throws UserNotFoundException{

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId ){
                return i;
            }
        }
        throw new UserNotFoundException(userId);
    }
    public User getUserByID(int userId) throws UserNotFoundException{

        return users.get(this.findUserIndexByID(userId));
    }

    private List<User> loadDataBase(){

        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:users.json");
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;
        try{
            users = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return users;
    }
}