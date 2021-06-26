package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.CountUserFollowerDTO;
import com.meli.SocialMeli.dto.CreateUserDTO;
import com.meli.SocialMeli.dto.ListFollowersUserDTO;
import com.meli.SocialMeli.exceptions.UserIsNotSeller;
import com.meli.SocialMeli.exceptions.UserNotFoundException;
import com.meli.SocialMeli.models.User;

import java.util.List;

public interface IUserService {
    void FollowUser(int userId, int userIdToFollow) throws UserNotFoundException, UserIsNotSeller;

    List<User> CreateUser(CreateUserDTO createUserDto);

    List<User> getUsers();

    ListFollowersUserDTO getListFollowers(int userIdListFollower);

    CountUserFollowerDTO getFollowersCount(int userIdCount);
}

