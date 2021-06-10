package com.desafio1.meli.service;

import com.desafio1.meli.service.DTO.*;
import com.desafio1.meli.service.orderType.UserOrderType;

public interface IUserService {
    boolean followUser(Integer userId, Integer userIdToFollow);
    boolean unFollowUser(Integer userId, Integer userIdToFollow);
    ResponseCountFollower countFollowUser (Integer userId);
    ResponseFollowersListDTO listFollowerUser (Integer userId, UserOrderType order);
    ResponseFollowsListDTO listFollowUser (Integer userId,UserOrderType order);
}
