package com.desafio.SocialMeli.Repository.User;

import com.desafio.SocialMeli.Classes.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    List<User> userList = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User getUserById(int userId) {
        return userList.stream().filter(user -> user.getUserId() == userId).findFirst().orElse(null);
    }

    @Override
    public void saveUser(User user) {
        user.setUserId(userList.size());
        userList.add(user);
    }

}
