package com.meli.spring_challenge.service.follow;

import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.service.dto.FollowersCountDto;
import com.meli.spring_challenge.service.dto.FollowDto;

import java.util.List;

public interface FollowService {
    void followUser(int userID, int followedUserID);
    List<Follow> getAllFollows();
    FollowersCountDto getFollowCountByUserID(int userId);
    FollowDto getFollowersByUserID(int userId);
    FollowDto getFollowedByUserID(int userID);
}
