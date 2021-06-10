package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.CountUserFollowerDto;
import com.meli.SocialMeli.dto.CreateUserDto;
import com.meli.SocialMeli.dto.ListFollowersUserDto;
import com.meli.SocialMeli.exceptions.UserIsNotSeller;
import com.meli.SocialMeli.exceptions.UserNotFoundException;
import com.meli.SocialMeli.models.User;

import java.util.List;

public interface IUserService {
    void FollowUser(int userId, int userIdToFollow) throws UserNotFoundException, UserIsNotSeller;

    List<User> CreateUser(CreateUserDto createUserDto);

    List<User> getUsers();

    ListFollowersUserDto getListFollowers(int userIdListFollower);

    CountUserFollowerDto getFollowersCount(int userIdCount);
}

