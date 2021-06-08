package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository implements IUserRepository{
    public static HashMap<Integer, User> users;
    static {
        users=new HashMap<>();
        users.put(1, new User(1,"Usuario 1"));
        users.put(2, new User(2,"Vendedor 1"));
        users.put(3, new User(3,"Usuario 2"));
        users.put(4, new User(4,"Vendedor 2"));
        users.put(5, new User(5,"Usuario 3"));
        users.put(1235, new User(1235,"Usuario prueba"));
    }

    @Override
    public User getUserById(int userId) {
        return users.get(userId);
    }

    @Override
    public void saveUser(User user) {
        users.put(user.getUserId(),user);
    }
}
