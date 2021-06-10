package com.SocialMeli.repositories;

import com.SocialMeli.controller.UserController;
import com.SocialMeli.models.User;
import java.util.stream.Stream;
import java.util.ArrayList;

public interface IUserRepository {
    User addFollowUserDTO(int userId, int userIdToFollow) throws UnhandledException;

    User findUserById(int userId) throws UnhandledException;

    ArrayList<User> findFollowersByUserId(int userId) throws UnhandledException;

    ArrayList<User> findFollowedByUserId(int userId) throws UnhandledException;

    Boolean follow(Integer userID, Integer useridtofollow);

    public Stream<User> getUserFollowersById(int userId);

}