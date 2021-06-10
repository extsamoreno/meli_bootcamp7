package com.socialMeli.services;

import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.DTOs.FollowListDTO;
import com.socialMeli.models.DTOs.FollowersCountDTO;
import com.socialMeli.models.DTOs.UserDTO;
import com.socialMeli.models.Seller;

import java.util.ArrayList;

public interface iUserService {

    Void follow (Integer userId, Integer userIdToFollow) throws UserNotFoundException;
    FollowersCountDTO countFollowers (Integer userId) throws UserNotFoundException;
    FollowListDTO listFollowers (Integer userId) throws UserNotFoundException;
    FollowListDTO listFollowed (Integer userId) throws UserNotFoundException;
    Void unfollow (Integer userId, Integer userIdToUnfollow) throws UserNotFoundException;
    ArrayList<UserDTO> orderFollowersByName(Integer sellerId, String order) throws UserNotFoundException, WrongCriteriaOrderException;
    ArrayList<Seller> orderFollowedByName(Integer userId, String order) throws UserNotFoundException, WrongCriteriaOrderException;
}
