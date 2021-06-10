package com.meli.socialmeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    Map<Integer, User> users;
    Map<Integer, List<Integer>> follow;
    File file;
    ObjectMapper objectMapper;

    public UserRepositoryImpl() {
        this.users = new HashMap<>();
        this.follow = new HashMap<>();
        this.objectMapper = new ObjectMapper();
        List<User> userList = loadUsers();
        this.follow = loadFollow();
        for (User user : userList) {
            users.put(user.getUserId(), user);
        }
    }

    @Override
    public User findById(int userId) {
        return users.get(userId);
    }

    @Override
    public User findByName(String userName) {
        Optional<User> optionalUser = users.values().stream().filter(e -> e.getUserName().compareTo(userName) == 0).findFirst();
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
        int key = users.size() + 1;
        user.setUserId(key);
        users.put(key, user);
        follow.put(user.getUserId(), new ArrayList<>());
        return user;
    }

    @Override
    public boolean userFollowingUserById(int userId, int userIdFollowing) {
        List<Integer> followers = follow.get(userIdFollowing);
        return followers.contains(userId);
    }

    @Override
    public void followUser(int userId, int userIdToFollow) {
        List<Integer> followers = follow.get(userIdToFollow);
        followers.add(userId);
        follow.put(userIdToFollow, followers);
        updateJsonFollow(this.follow);
    }

    @Override
    public void UnfollowUser(int userId, int userIdToFollow) {
        List<Integer> followers = follow.get(userIdToFollow);
        followers.removeIf(e -> e == userId);
        follow.put(userIdToFollow, followers);
    }

    @Override
    public int countFollowersByUserId(int userId) {
        return follow.get(userId).size();
    }

    @Override
    public List<Integer> getFollowersByUserId(int userId) {
        return follow.get(userId);
    }

    @Override
    public List<Integer> getFollowingByUserId(int userId) {
        return users.keySet().stream().filter(e -> follow.get(e).contains(userId)).collect(Collectors.toList());
    }

    private List<User> loadUsers() {
        try {
            this.file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> users = null;
        try {
            users = this.objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private Map<Integer, List<Integer>> loadFollow() {
        try {
            this.file = ResourceUtils.getFile("classpath:follow.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TypeReference<Map<Integer, List<Integer>>> typeRef = new TypeReference<>() {
        };
        Map<Integer, List<Integer>> follow = null;
        try {
            follow = this.objectMapper.readValue(this.file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return follow;
    }

    private void updateJsonFollow(Map<Integer, List<Integer>> follow) {
        try {
            String jsonString = this.objectMapper.writeValueAsString(follow);

            FileWriter myWriter = new FileWriter("src/main/resources/follow.json", false);
            myWriter.write(jsonString);
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
