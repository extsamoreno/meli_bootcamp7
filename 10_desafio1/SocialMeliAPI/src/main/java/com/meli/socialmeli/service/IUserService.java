package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserNotFoundException;
import com.meli.socialmeli.service.dto.UserDTOFollowedList;
import com.meli.socialmeli.service.dto.UserDTOFollowersCount;
import com.meli.socialmeli.service.dto.UserDTOFollowersList;
import org.springframework.http.HttpStatus;

public interface IUserService {
    public HttpStatus followUser(int userId, int userIdToFollow) throws UserAlreadyFollowedException;
    public UserDTOFollowersCount getFollowersCount(int userId) throws UserNotFoundException;
    public UserDTOFollowersList getFollowersList(int userId) throws UserNotFoundException;
    public UserDTOFollowedList getFollowedList(int userId) throws UserNotFoundException;
}
