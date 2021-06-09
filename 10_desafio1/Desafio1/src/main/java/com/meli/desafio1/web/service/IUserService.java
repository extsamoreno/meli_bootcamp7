package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.exception.UserException;
import com.meli.desafio1.web.exception.UserNotFoundException;
import com.meli.desafio1.web.response.CusersResponse;

import java.util.List;

public interface IUserService {
    public void follow(int userId, int follow_id) throws UserException;
    public CusersResponse cUserFollowers(int userId) throws UserNotFoundException;
    public String userNameByUserId(int userId);
    public List<UserDTO> followersByUserId(int userId, String order);
    public List<UserDTO> followedByUserId(int userId, String order);
    public int unFollow(int userId, int follow_id);
    public void orderUserDTO(List<UserDTO> userDTOS, String order);
}
