package com.example.desafio1.repositories;

import com.example.desafio1.exceptions.FollowingDoesNotExistException;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.models.MeliUser;

import java.util.List;

public interface IUserRepository {
    boolean addFollowing(int userId, int userIdToFollow);

    MeliUser getUserById(int userId);

    int getFollowersCount(int userId);

    List<MeliUser> getFollowers(int userId, String order) throws OrderNotValidException;

    List<MeliUser> getFollowed(int userId, String order) throws OrderNotValidException;

    boolean doesFollowingExist(int userId, int userIdFollowed);

    void removeFollowing(int userId, int userIdToUnfollow) throws FollowingDoesNotExistException;
}
