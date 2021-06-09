package com.meli.desafio.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio.posts.models.Post;
import com.meli.desafio.users.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class DataBase {
    public static List<User> listUsers = new ArrayList<>();
    public static List<Post> listPosts = new ArrayList<>();

    public void loadUsers() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> listUsers = null;

        try{
            listUsers = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        for(User u: listUsers){
            this.listUsers.add(u);
        }
    }

    public void loadPosts() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:post.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};
        List<Post> listPosts = null;

        try{
            listPosts = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        for(Post p: listPosts){
            this.listPosts.add(p);
        }
    }

    public void writeDataBase(){
        File file = null;
        PrintWriter pw = null;
        try{
            file = ResourceUtils.getFile("classpath:users.json");
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
