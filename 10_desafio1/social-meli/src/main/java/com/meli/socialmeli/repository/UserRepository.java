package com.meli.socialmeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.model.Follow;
import com.meli.socialmeli.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    private List<Follow> follows;
    private List<User> users;

    public UserRepository() {
        this.follows = new ArrayList<>();
        this.users = loadDatabase();
    }

    @Override
    public User findUserById(Integer userId) {
        User user = null;

        if(this.users != null) {
            Optional<User> item = this.users.stream().filter(i -> i.getUserId().equals(userId)).findFirst();
            if (item.isPresent()) user = item.get();
        }

        return user;
    }

    @Override
    public void addFollower(User userTo, User userFrom) {
        Optional<Follow> item = this.follows.stream().filter(i -> i.getUserTo().getUserId().equals(userTo.getUserId()) && i.getUserFrom().getUserId().equals(userFrom.getUserId())).findFirst();

        if(item.isEmpty()) {
            this.follows.add(new Follow(userFrom,userTo));
        }
    }

    @Override
    public List<User> getUserFollowers(Integer userId) {
        List<Follow> fs = this.follows.stream().filter(i -> i.getUserTo().getUserId().equals(userId)).collect(Collectors.toList());
        List<User> followers = new ArrayList<>();

        for (Follow f : fs) {
            followers.add(f.getUserFrom());
        }

        return followers;
    }

    @Override
    public List<User> getUserFollowed(Integer userId) {
        List<Follow> fs = this.follows.stream().filter(i -> i.getUserFrom().getUserId().equals(userId)).collect(Collectors.toList());
        List<User> followed = new ArrayList<>();

        for (Follow f : fs) {
            followed.add(f.getUserTo());
        }

        return followed;
    }

    private List<User> loadDatabase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:users.json");
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

        return users;
    }
}
