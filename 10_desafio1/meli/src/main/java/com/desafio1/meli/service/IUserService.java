package com.desafio1.meli.service;

import com.desafio1.meli.model.User;
import com.desafio1.meli.service.DTO.RequestFollowUserToUser;

public interface IUserService {
    boolean followUser(Integer userId, Integer userIdToFollow);
    Integer countFollowUser (Integer userId);
}
