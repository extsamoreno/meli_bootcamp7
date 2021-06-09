package com.example.desafio_1.repository;

import com.example.desafio_1.models.Buyer;
import com.example.desafio_1.models.Seller;
import com.example.desafio_1.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserRepository implements IUserRepository{

    private HashMap<Integer, User> users;
    public UserRepository() {
        this.users = new HashMap<Integer, User>(); //Load data
        add(new Buyer("Genaro"));
        add(new Buyer("Nico"));
        add(new Buyer("Martincite"));
        add(new Buyer("Fede"));

        add(new Seller("Jorge"));
        add(new Seller("Gustavo"));
        add(new Seller("Belen"));
        add(new Seller("Camila"));
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        int newId = this.users.size() + 1;
        user.setId(newId);
        this.users.put(newId, user);
    }

    @Override
    public void followUser(Buyer userFollower, Seller userToFollow) {
        userToFollow.getFollowers().put(userFollower.getId(), userFollower);
        userFollower.getFollowing().put(userToFollow.getId(), userToFollow);
    }

}
