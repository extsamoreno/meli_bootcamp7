package com.socialmedia.socialmedia.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.repositories.entities.Follower;
import com.socialmedia.socialmedia.repositories.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    @Override
    public int followToUser(int userId, int userIdToFollow) {
        List<Follower> followers = loadDatabaseFollowers();

        followers.add(new Follower(followers.size() + 1, userIdToFollow, userId));

        updateDatabaseFollowers(followers);

        return 0;
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        List<User> users = loadDatabaseUsers();
        List<Follower> followers = loadDatabaseFollowers();

        var userOptional = users.stream().filter(user -> user.getId() == userId).findFirst();

        if (userOptional.isEmpty()) throw new UserNotFoundException(userId);

        var userResult = userOptional.get();

        List<Follower> followersByUser = followers.stream()
                .filter(follower -> follower.getUserId() == userId).collect(Collectors.toList());

        userResult.setFollowers(followersByUser);

        return userResult;
    }

    private List<User> loadDatabaseUsers() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<User>> typeReference = new TypeReference<>() {
        };
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return users;
    }

    private List<Follower> loadDatabaseFollowers() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:followers.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Follower>> typeReference = new TypeReference<>() {
        };
        List<Follower> followers = null;
        try {
            followers = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return followers;
    }

    private void updateDatabaseFollowers(List<Follower> followers) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(followers);

            FileWriter myWriter = new FileWriter("src/main/resources/followers.json", false);
            myWriter.write(jsonString);
            myWriter.close();

        } catch (Exception ex) {
            System.out.println("Error al convertir a json");
            ex.printStackTrace();
        }
    }
}
