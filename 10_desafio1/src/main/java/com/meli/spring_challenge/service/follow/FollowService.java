package com.meli.spring_challenge.service.follow;

import com.meli.spring_challenge.exception.UserNotFoundException;
import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.service.dto.FollowersCountDto;
import com.meli.spring_challenge.service.dto.FollowDto;

import java.util.List;

public interface FollowService {
    void followUser(int userID, int followedUserID) throws UserNotFoundException;
    List<Follow> getAllFollows();
    FollowersCountDto getFollowCountByUserID(int userId) throws UserNotFoundException;
    FollowDto getFollowersByUserID(int userId) throws UserNotFoundException;
    FollowDto getFollowedByUserID(int userID) throws UserNotFoundException;
}
