package com.desafio1.meli.service;

import com.desafio1.meli.model.User;
import com.desafio1.meli.service.DTO.RequestFollowUserToUser;
import com.desafio1.meli.service.DTO.ResponseCountFollower;

public interface IUserService {
    boolean followUser(Integer userId, Integer userIdToFollow);
    ResponseCountFollower countFollowUser (Integer userId);
}
