package com.challenge.service;

import com.challenge.dto.FollowersCountResponse;
import com.challenge.dto.FollowersResponse;
import com.challenge.enums.SortingUserEnum;
import com.challenge.exception.UserIdNotFoundException;

import java.io.IOException;

public interface UserService {

    void follow(Integer userId, Integer userToFollow) throws IOException, UserIdNotFoundException;
    FollowersCountResponse getFollowersCount(Integer userId) throws UserIdNotFoundException;
    FollowersResponse getFollowers(Integer userId, SortingUserEnum sortingUserEnum) throws UserIdNotFoundException;
    FollowersResponse getFollows(Integer userId, SortingUserEnum sortingUserEnum) throws UserIdNotFoundException;
    void unfollow(Integer userId, Integer userToUnfollow) throws UserIdNotFoundException;


}
