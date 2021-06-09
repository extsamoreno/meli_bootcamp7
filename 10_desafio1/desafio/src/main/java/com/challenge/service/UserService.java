package com.challenge.service;

import com.challenge.dto.UserDTO;
import com.challenge.enums.SortingUserEnum;
import com.challenge.exception.UserIdNotFoundException;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void follow(Integer userId, Integer userToFollow) throws IOException, UserIdNotFoundException;
    Integer getFollowersCount(Integer userId) throws UserIdNotFoundException;
    List<UserDTO> getFollowers(Integer userId, SortingUserEnum sortingUserEnum) throws UserIdNotFoundException;
    List<UserDTO> getFollows(Integer userId, SortingUserEnum sortingUserEnum) throws UserIdNotFoundException;
    void unfollow(Integer userId, Integer userToUnfollow) throws UserIdNotFoundException;


}
