package com.challenge.repository;

import com.challenge.entity.Post;
import com.challenge.entity.Product;
import com.challenge.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<Product> productList;
    private List<Post> postList;
    private List<User> userList;
    private Multimap<Integer, Integer> follows;
    private Multimap<Integer, Integer> followedBy;

    public void follow(Integer userId, Integer userIdToFollow) throws IOException {
        if (!follows.get(userId).contains(userIdToFollow)) {
            follows.put(userId, userIdToFollow);
            followedBy.put(userIdToFollow, userId);
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new GuavaModule());
            //TODO change the absolute path to the classpath (now used to keep data upon re-compile)
            objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/users_follows.json"), follows);
            objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/followed_by.json"), followedBy);
        }
    }

    public List<User> getFollowers(Integer userId) {
        List<Integer> followersIds = (List<Integer>) followedBy.get(userId);
        List<User> followers = new ArrayList<>();
        userList.forEach(u -> {
            if (followersIds.contains(u.getUserId())) {
                followers.add(u);
            }
        });

        return followers;
    }

    public List<User> getFollows(Integer userId) {
        List<Integer> followsIds = (List<Integer>) follows.get(userId);
        List<User> follows = new ArrayList<>();
        userList.forEach(u -> {
            if (followsIds.contains(u.getUserId())) {
                follows.add(u);
            }
        });

        return follows;
    }

    public Integer getFollowersCount(Integer userId) {
        return followedBy.get(userId).size();
    }

    @PostConstruct
    private void init() {
       this.productList = loadProductList();
       this.postList = loadPostList();
       this.follows = loadFollowsMap();
       this.followedBy = loadFollowedByMap();
       this.userList = loadUserList();
    }


    private Multimap<Integer, Integer> loadFollowedByMap() {
        File file = null;
        try {
            //TODO change the absolute path to the classpath (now used to keep data upon re-compile)
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/followed_by.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new GuavaModule());
        TypeReference<ArrayListMultimap<Integer, Integer>> typeRef = new TypeReference<>() {};
        Multimap<Integer, Integer> followers = ArrayListMultimap.create();

        try {
            followers = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return followers;
    }

    private Multimap<Integer, Integer> loadFollowsMap() {
        File file = null;
        try {
            //TODO change the absolute path to the classpath (now used to keep data upon re-compile)
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/users_follows.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new GuavaModule());
        TypeReference<ArrayListMultimap<Integer, Integer>> typeRef = new TypeReference<>() {};
        Multimap<Integer, Integer> follows = ArrayListMultimap.create();

        try {
            follows = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return follows;
    }

    private List<Post> loadPostList() {
        File file = null;
        try {
            //TODO change the absolute path to the classpath (now used to keep data upon re-compile)
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Post>> typeRef = new TypeReference<>() {};
        List<Post> posts = null;

        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts;
    }

    private List<User> loadUserList() {
        File file = null;
        try {
            //TODO change the absolute path to the classpath (now used to keep data upon re-compile)
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;

        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        List<User> finalUsers = users;
//        users.forEach(u -> {
//            List<Post> posts = new ArrayList<>();
//            postList.forEach(p -> {
//                if (p.getUserId() == u.getUserId()) {
//                    posts.add(p);
//                }
//            });
//            u.setPosts(posts);
//            List<User> userFollows = new ArrayList<>();
//            finalUsers.forEach(u1 -> {
//                if (follows.get(u.getUserId()).contains(u1.getUserId())){
//                   userFollows.add(u1);
//                }
//            });
//            u.setFollows(userFollows);
//        });
        return users;
    }

    private List<Product> loadProductList() {
        File file = null;
        try {
            //TODO change the absolute path to the classpath (now used to keep data upon re-compile)
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/products.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
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
