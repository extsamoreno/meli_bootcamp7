package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.MissingParameterException;
import com.meli.socialmeli.exception.UserAlreadyFollowingUserException;
import com.meli.socialmeli.exception.UserNotExistsException;
import com.meli.socialmeli.service.dto.SellerDTO;
import com.meli.socialmeli.service.dto.UserBaseDTO;
import com.meli.socialmeli.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void createUserFromList(List<UserBaseDTO> userList);

    List<UserBaseDTO> getUserList();

    void followUser(int userId, int userIdToFollow) throws UserNotExistsException, UserAlreadyFollowingUserException;

    void unfollowUser(int userId, int userIdToUnfollow) throws UserNotExistsException;

    int countFollowersByUserId(Optional<Integer> userId) throws UserNotExistsException, MissingParameterException;

    SellerDTO getFollowersByUserId(Optional<Integer> userId, String order) throws UserNotExistsException, MissingParameterException;

    UserDTO getFollowingByUserId(Optional<Integer> userId, String order) throws UserNotExistsException, MissingParameterException;

    void userExists(int userId) throws UserNotExistsException;

}
