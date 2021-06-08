package com.desafiospring.socialMeli.repository;

import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.model.User;

public interface ISocialMeliRepository {

    public User findUserById(int id) throws UserNotFoundException;

    public void addFollowerToUser(int userId, int userIdToFollow) throws UserNotFoundException;

    public int getFollowersCount(int userId);
}
