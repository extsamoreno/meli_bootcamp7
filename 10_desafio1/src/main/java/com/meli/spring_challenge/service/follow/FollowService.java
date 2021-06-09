package com.meli.spring_challenge.service.follow;

import com.meli.spring_challenge.exception.user.UserGuestException;
import com.meli.spring_challenge.exception.user.UserNotFoundException;
import com.meli.spring_challenge.exception.user.UserNotSellerException;
import com.meli.spring_challenge.exception.user.UserRelationNotFoundException;
import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.service.dto.FollowersCountDto;
import com.meli.spring_challenge.service.dto.FollowDto;

import java.util.List;

public interface FollowService {
    void followUser(int userID, int followedUserID) throws UserNotFoundException;
    List<Follow> getAllFollows();
    FollowersCountDto getFollowCountByUserID(int userId) throws UserNotFoundException;
    FollowDto getFollowersByUserID(int userId) throws UserNotFoundException, UserNotSellerException;
    FollowDto getFollowedByUserID(int userID, String order) throws UserNotFoundException, UserGuestException;
    void unfollowUser(int userID, int userIdToFollow) throws UserRelationNotFoundException, UserNotFoundException;
}
