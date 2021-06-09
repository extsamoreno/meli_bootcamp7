package com.socialMeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.socialMeli.exceptions.*;
import com.socialMeli.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SocialMeliRepository implements iSocialMeliRepository {

    private HashMap<Integer, User> users;
    private HashMap<Integer, Seller> sellers;
    private AtomicInteger userId;

    private HashMap<Integer, Post> posts;
    private AtomicInteger postId;

    public SocialMeliRepository(){
        this.users = new HashMap<>();

    }

    @Override
    public List<Object> loadDatabase(String pathFile) throws FailLoadDatabase {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:"+pathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Object>> typeRef = new TypeReference<>() {};
        List<Object> objectJSON = null;

        try {
            objectJSON = objectMapper.readValue(file, typeRef);
        } catch(IOException e) {
            throw new FailLoadDatabase(pathFile);
        }
        return objectJSON;
    }

    @Override
    public void updateDatabase(List<User> users, String pathFile) throws FailUploadDatabase {
        FileWriter file = null;
        try {
            file = new FileWriter("classpath:"+pathFile);
            file.write(new Gson().toJson(users));
        } catch(IOException e) {
            throw new FailUploadDatabase(pathFile);
        }
    }

    @Override
    public Object findById(Integer id) throws UserNotFoundException {
        Object result = users.get(userId);
        if (result == null)
            result = sellers.get(userId);
        if (result == null)
            throw new UserNotFoundException(id);
        return result;
    }

    @Override
    public Integer findByUser (Object user) throws UserIdNotFoundException {
        Integer result = null;
        for (Map.Entry<Integer, User> entry : this.users.entrySet()) {
            if (user.equals(entry.getValue()))
                result = entry.getKey();
        }
        if (result == null) {
            for (Map.Entry<Integer, Seller> entry : this.sellers.entrySet()) {
                if (user.equals(entry.getValue()))
                    result = entry.getKey();
            }
        }
        if (result == null)
            throw new UserIdNotFoundException();
        return result;
    }

    @Override
    public void newPost(StandardPost newPost) throws FailCreatePostException {
        try {
            this.posts.put(this.postId.getAndIncrement(), newPost);
        } catch (Exception e){
            throw new FailCreatePostException();
        }
    }

    @Override
    public void newPromoPost(PromoPost newPromoPost) throws FailCreatePostException {
        try {
            this.posts.put(this.postId.getAndIncrement(), newPromoPost);
        } catch (Exception e){
            throw new FailCreatePostException();
        }
    }
}
