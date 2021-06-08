package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.SocialExceptionMissingParameter;
import com.meli.socialmeli.exception.SocialExceptionUserNotExists;
import com.meli.socialmeli.service.dto.SellerDTO;
import com.meli.socialmeli.service.dto.UserBaseDTO;
import com.meli.socialmeli.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void createUserFromList(List<UserBaseDTO> userList);

    List<UserBaseDTO> getUserList();

    void followUser(int userId, int userIdToFollow) throws SocialExceptionUserNotExists;

    int getFollowersAmountByUserId(Optional<Integer> userId) throws SocialExceptionUserNotExists, SocialExceptionMissingParameter;

    SellerDTO getFollowersByUserId(Optional<Integer> userId) throws SocialExceptionUserNotExists, SocialExceptionMissingParameter;

    UserDTO getFollowingByUserId(Optional<Integer> userId);

}
