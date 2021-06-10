package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;

public interface IUserRepository {
    User userAdd(User user);

    boolean userFollow(int userid, int useridFollow);

    User getUserById(int userId);

    boolean userUnFollow(int userid, int useridFollow);
}
