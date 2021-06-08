package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.response.CusersResponse;

import java.util.List;

public interface IUserService {
    public int follow(int userId, int follow_id);
    public CusersResponse cUserFollowers(int userId);
    public String userNameByUserId(int userId);
    public List<UserDTO> followersByUserId(int userId);
    public List<UserDTO> followedByUserId(int userId);
}
