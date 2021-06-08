package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.UserFollowedListDto;
import com.meli.SocialMeli.dto.UserFollowerCountDto;
import com.meli.SocialMeli.dto.UserFollowerListDto;
import com.meli.SocialMeli.dto.UserNewDto;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.exception.InvalidUserNameException;

public interface IUserService {
    void newUser(UserNewDto userNewDto) throws InvalidUserNameException;

    void follow(int followerId, int followedId) throws InvalidUserIdException;

    UserFollowerCountDto followerCount(int id) throws InvalidUserIdException;

    UserFollowerListDto followerList(int id) throws InvalidUserIdException;

    UserFollowedListDto followedList(int id) throws InvalidUserIdException;
}
