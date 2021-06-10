package com.desafio1.meli.service;

import com.desafio1.meli.exceptions.NotExistUser;
import com.desafio1.meli.service.DTO.*;
import com.desafio1.meli.service.orderType.UserOrderType;

public interface IUserService {
    boolean followUser(Integer userId, Integer userIdToFollow) throws NotExistUser;
    boolean unFollowUser(Integer userId, Integer userIdToFollow) throws NotExistUser;
    ResponseCountFollower countFollowUser (Integer userId) throws NotExistUser;
    ResponseFollowersListDTO listFollowerUser (Integer userId, UserOrderType order) throws NotExistUser;
    ResponseFollowsListDTO listFollowUser (Integer userId,UserOrderType order) throws NotExistUser;
}
