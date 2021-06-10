package com.socialMeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialMeli.exceptions.FailCreatePostException;
import com.socialMeli.exceptions.FailLoadDatabase;
import com.socialMeli.exceptions.UserIdNotFoundException;
import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.models.Post;
import com.socialMeli.models.PromoPost;
import com.socialMeli.models.Seller;
import com.socialMeli.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SocialMeliRepository implements iSocialMeliRepository {

    private HashMap<Integer, User> users;
    private HashMap<Integer, Seller> sellers;
    private AtomicInteger userId;

    private AtomicInteger postId;

    public SocialMeliRepository() throws FailLoadDatabase {
        this.userId = new AtomicInteger(1);
        this.postId = new AtomicInteger(1);
        loadUsersHashmap();
        loadSellersHashMap();
    }

    @Override
    public List<User> loadDatabase(String pathFile) throws FailLoadDatabase {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:"+pathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> userJSON = null;

        try {
            userJSON = objectMapper.readValue(file, typeRef);
        } catch(IOException e) {
            throw new FailLoadDatabase(pathFile);
        }
        return userJSON;
    }

    @Override
    public void loadUsersHashmap() throws FailLoadDatabase {
        this.users = new HashMap<>();
        List<User> usersDB = loadDatabase("users.json");
        usersDB.stream().forEach(user -> this.users.put(this.userId.getAndIncrement(), user));
    }

    @Override
    public void loadSellersHashMap () {
        this.sellers = new HashMap<>();
        for (Map.Entry<Integer, User> entry : this.users.entrySet()) {
            entry.getValue().getFollowing().stream().forEach(seller -> this.sellers.put(this.userId.getAndIncrement(), seller));
        }
    }

    @Override
    public Seller findSellerById(Integer id) throws UserNotFoundException {
        if (this.sellers.get(id) == null)
            throw new UserNotFoundException(id);
        return sellers.get(id);
    }

    @Override
    public User findUserById(Integer id) throws UserNotFoundException {
        if (this.users.get(id) == null)
            throw new UserNotFoundException(id);
        return this.users.get(id);
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
    public void newPost(Post newPost) throws FailCreatePostException {
        try {
            this.sellers.get(newPost.getSellerId()).getPosts().add(newPost);
        } catch (Exception e){
            throw new FailCreatePostException();
        }
    }

    @Override
    public void newPost(PromoPost newPromoPost) throws FailCreatePostException {
        try {
            this.sellers.get(newPromoPost.getSellerId()).getPromoPosts().add(newPromoPost);
        } catch (Exception e){
            throw new FailCreatePostException();
        }
    }

}
