package com.desafio1.meli.service;

import com.desafio1.meli.model.*;
import com.desafio1.meli.service.DTO.*;

public interface IUserService {
    boolean followUser(Integer userId, Integer userIdToFollow);
    ResponseCountFollower countFollowUser (Integer userId);
    ResponseFollowersListDTO listFollowerUser (Integer userId);
    ResponseFollowsListDTO listFollowUser (Integer userId);
}
