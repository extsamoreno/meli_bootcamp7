package com.meli.socialmeli.model.dao.repository;

import com.meli.socialmeli.database.DataBasePost;
import com.meli.socialmeli.database.DataBaseUsers;
import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepositoryUsersImpl implements RepositoryUsers{
    private ArrayList<User> dataBaseUsers = DataBaseUsers.dataBaseUsers;

    public User getUserById(int userId) {
        ArrayList<User> userList = dataBaseUsers;
        User userReturn = null;
        for (User user: dataBaseUsers) {
            if(user.getUserId() == userId) {
                userReturn = user;
            }
        }
        return userReturn;
    }
}
