package com.meli.socialmeli.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final List<User> users;

    public UserRepository() {
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
    public boolean addFollower(User userTo, User userFrom) {
        User user = this.users.stream().filter(usr -> usr.getUserId().equals(userFrom.getUserId())).findFirst().get();
        User userToFollow = this.users.stream().filter(usr -> usr.getUserId().equals(userTo.getUserId())).findFirst().get();

        //Check first if the user is not already following the other user
        Optional<User> item = user.getFollowed().stream().filter(followed -> followed.getUserId().equals(userTo.getUserId())).findFirst();

        if(item.isEmpty()) {
            user.getFollowed().add(userTo);
            userToFollow.getFollowers().add(userFrom);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUserFollowers(Integer userId, String order) {
        User user = this.users.stream().filter(usr -> usr.getUserId().equals(userId)).findFirst().get();
        List<User> followers = user.getFollowers();

        if(order != null && order.equals("name_asc"))
            followers.sort(Comparator.comparing(User::getUserName));

        if(order != null && order.equals("name_desc"))
            followers.sort((f1, f2) -> f2.getUserName().compareTo(f1.getUserName()));

        return followers;
    }

    @Override
    public List<User> getUserFollowed(Integer userId, String order) {
        User user = this.users.stream().filter(usr -> usr.getUserId().equals(userId)).findFirst().get();
        List<User> followed = user.getFollowed();

        if(order != null && order.equals("name_asc"))
            followed.sort(Comparator.comparing(User::getUserName));

        if(order != null && order.equals("name_desc"))
            followed.sort((f1, f2) -> f2.getUserName().compareTo(f1.getUserName()));

        return followed;
    }

    @Override
    public boolean deleteFollower(Integer userId, Integer userIdToUnfollow) {
        User user = this.users.stream().filter(usr -> usr.getUserId().equals(userId)).findFirst().get();
        User userToUnfollow = this.users.stream().filter(usr -> usr.getUserId().equals(userIdToUnfollow)).findFirst().get();

        //Check first if the user is following the other user
        Optional<User> item = user.getFollowed().stream().filter(followed -> followed.getUserId().equals(userIdToUnfollow)).findFirst();

        if(item.isPresent()) {
            user.getFollowed().remove(item.get());
            userToUnfollow.getFollowers().remove(user);
            return true;
        }

        return false;
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
