package com.example.desafio1.repository;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepository implements iUserRepository {

    HashMap<Integer, User> mapUsers = new HashMap();

    public UserRepository() {
        loadUsers();
    }

    // Update user data
    @Override
    public User saveUser(User user) {

        mapUsers.put(user.getUserId(), user);
        return user;
    }

    // Search user by Id
    @Override
    public User findUserById(Integer id) {
        return mapUsers.get(id);
    }

    @Override
    // Load default users
    public void loadUsers() {

        // Sellers
        mapUsers.put(0, new User(0, "tomas", true, new ArrayList<User>(), new ArrayList<User>()));
        mapUsers.put(1, new User(1, "carlos", true, new ArrayList<User>(), new ArrayList<User>()));

        // Buyers
        mapUsers.put(2, new User(2, "agustin", false, new ArrayList<User>(), new ArrayList<User>()));
        mapUsers.put(3, new User(3, "mario", false, new ArrayList<User>(), new ArrayList<User>()));
    }
}
