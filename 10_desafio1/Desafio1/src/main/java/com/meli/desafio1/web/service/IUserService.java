package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.exception.UserException;
import com.meli.desafio1.web.exception.UserNotFoundException;
import com.meli.desafio1.web.response.CusersResponse;
import com.meli.desafio1.web.response.FollowedListResponse;
import com.meli.desafio1.web.response.FollowersListResponse;

import java.util.List;

public interface IUserService {
    public void follow(int userId, int follow_id) throws UserException;
    public CusersResponse cUserFollowers(int userId) throws UserNotFoundException;
    public FollowersListResponse followersByUserId(int userId, String order) throws UserException;
    public FollowedListResponse followedByUserId(int userId, String order) throws  UserException;
    public void unFollow(int userId, int follow_id) throws  UserException;
    public void orderUserDTO(List<UserDTO> userDTOS, String order);
}
