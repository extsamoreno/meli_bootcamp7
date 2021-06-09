package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.UserFollowedListDto;
import com.meli.SocialMeli.dto.UserFollowerCountDto;
import com.meli.SocialMeli.dto.UserFollowerListDto;
import com.meli.SocialMeli.dto.UserNewDto;
import com.meli.SocialMeli.exception.FollowNotFoundUserException;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.exception.InvalidUserNameException;
import com.meli.SocialMeli.exception.RepeatedFollowUserException;

import java.util.Optional;

public interface IUserService {
    void newUser(UserNewDto userNewDto) throws InvalidUserNameException;

    void follow(int followerId, int followedId) throws InvalidUserIdException, RepeatedFollowUserException;

    UserFollowerCountDto followerCount(int id) throws InvalidUserIdException;

    UserFollowerListDto followerList(int id, Optional<String> order) throws InvalidUserIdException;

    UserFollowedListDto followedList(int id, Optional<String> order) throws InvalidUserIdException;

    void unfollow(int followerId, int followedId) throws FollowNotFoundUserException;
}
