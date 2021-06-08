package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    Map<Integer, User> users;
    Map<Integer, List<User>> follow;

    public UserRepositoryImpl() {
        this.users = new HashMap<>();
        this.follow = new HashMap<>();
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
    public void followUser(User user, int userIdToFollow) {
        List<User> followers = follow.get(userIdToFollow);
        followers.add(user);
        follow.put(userIdToFollow, followers);
    }

    @Override
    public void UnfollowUser(int userId, int userIdToFollow) {
        List<User> followers = follow.get(userIdToFollow);
        followers.removeIf(e -> e.getUserId() == userId);
        follow.put(userIdToFollow, followers);
    }

    @Override
    public int getFollowersAmountByUserId(int userId) {
        return follow.get(userId).size();
    }

    @Override
    public List<User> getFollowersByUserId(int userId) {
        return follow.get(userId);
    }

    @Override
    public List<Integer> getFollowingByUserId(int userId) {
        return users.keySet().stream().filter(e -> users.get(e).getUserId() == userId).collect(Collectors.toList());
    }
}
