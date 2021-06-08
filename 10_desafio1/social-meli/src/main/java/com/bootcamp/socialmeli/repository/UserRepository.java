package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    private static List<User> users = loadDatabase();

    @Override
    public User findById(Integer id) {

        return users.stream()
                .filter(user -> user.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<User> getUserFollowers(Integer id) {
        User user = findById(id);

        if (user == null) {
            //Throw a exception
        }

        return user.getFollowers()
                .stream()
                .map(followerId -> findById(followerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUserFollowed(Integer id) {
        User user = findById(id);

        if (user == null) {
            //Throw a exception
        }

        return user.getFollowed()
                .stream()
                .map(followedId -> findById(followedId))
                .collect(Collectors.toList());
    }

    private static List<User> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> users = null;

        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
