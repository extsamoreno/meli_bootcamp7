package com.desafiospring.socialMeli.repository;

import com.desafiospring.socialMeli.dto.UserDTO;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.model.User;

import java.util.List;

public interface IUserRepository {

    public User findUserById(int id) throws UserNotFoundException;

    public void addFollowerToUser(int userId, int userIdToFollow) throws UserNotFoundException;

    public int getFollowersCount(int userId);

    List<User> getFollowersList(int userId) throws UserNotFoundException;

    List<User> getFollowedList(int userId) throws UserNotFoundException;

    public void deleteFollower(int userId, int userIdToFollow) throws UserNotFoundException;

}
