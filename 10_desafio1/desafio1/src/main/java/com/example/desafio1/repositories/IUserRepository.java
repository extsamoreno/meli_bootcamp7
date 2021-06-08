package com.example.desafio1.repositories;

import com.example.desafio1.models.MeliUser;

import java.util.List;

public interface IUserRepository {
    boolean addFollowing(int userId, int userIdToFollow);
    MeliUser getUserById(int userId);
    int getFollowersCount(int userId);
    List<MeliUser> getFollowers(int userId);
    List<MeliUser> getFollowed(int userId);
    boolean doesFollowingExist(int userId, int UserIdFollowed);
}
