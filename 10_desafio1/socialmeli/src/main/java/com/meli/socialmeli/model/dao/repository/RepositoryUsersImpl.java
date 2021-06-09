package com.meli.socialmeli.model.dao.repository;

import com.meli.socialmeli.database.DataBaseUsers;
import com.meli.socialmeli.model.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepositoryUsersImpl implements RepositoryUsers{

    private final ArrayList<User> dataBaseUsers = DataBaseUsers.dataBaseUsers;

    public User getUserById(int userId) {
        User userReturn = null;
        for (User user: dataBaseUsers) {
            if(user.getUserId() == userId) {
                userReturn = user;
            }
        }
        return userReturn;
    }

}
