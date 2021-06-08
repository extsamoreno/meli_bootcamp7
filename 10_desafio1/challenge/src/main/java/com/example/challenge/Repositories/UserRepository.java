package com.example.challenge.Repositories;

import com.example.challenge.Exceptions.UserNoFoundException;
import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.FollowDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {

    private HashMap<Integer, User> users = new HashMap<>();

    @Override
    public FollowDTO follow(int followerId, int followedId) throws UserNoFoundException {
        User followed = this.users.get(followedId);
        User follower = this.users.get(followerId);

        followed.addFollower(follower);
        follower.addFollowed(followed);

        return new FollowDTO(followedId, followerId, "Follow");
    }

    public User findUserByID(int userId) throws UserNoFoundException {

        try {
            return this.users.get(userId);
        } catch (Exception e) {
            throw new UserNoFoundException(userId);
        }
    }


    public List<User> getUsers() {
        List<User> res = new ArrayList<>();
        for (Map.Entry<Integer, User> u : this.users.entrySet()) {
            res.add(u.getValue());
        }
        return res;
    }


    public String addUser(String userName) {
        int id = this.users.size() + 1;
        User newUser = new User();
        newUser.setName(userName);
        newUser.setId(id);
        newUser.setFollowed(new ArrayList<>());
        newUser.setFollowers(new ArrayList<>());
        newUser.setPosts(new ArrayList<>());
        this.users.put(id, newUser);
        return newUser.getName();
    }


}
