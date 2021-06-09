package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.IncorrectOrderTypeException;
import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserAlreadyUnfollowedException;
import com.meli.socialmeli.exception.UserNotFoundException;
import com.meli.socialmeli.service.dto.UserDTOFollowedList;
import com.meli.socialmeli.service.dto.UserDTOFollowersCount;
import com.meli.socialmeli.service.dto.UserDTOFollowersList;
import org.springframework.http.HttpStatus;

public interface IUserService {
    public HttpStatus followUser(int userId, int userIdToFollow) throws UserAlreadyFollowedException, UserNotFoundException;
    public UserDTOFollowersCount getFollowersCount(int userId) throws UserNotFoundException;
    public UserDTOFollowersList getFollowersList(int userId) throws UserNotFoundException;
    public UserDTOFollowedList getFollowedList(int userId) throws UserNotFoundException;
    public HttpStatus unfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException, UserAlreadyUnfollowedException;
    public UserDTOFollowersList getSortedFollowersList(int userId, String order) throws UserNotFoundException, IncorrectOrderTypeException;
    public UserDTOFollowedList getSortedFollowedList(int userId, String order) throws UserNotFoundException, IncorrectOrderTypeException;
}
