package com.desafio1.meli.repository.userRepository;

import com.desafio1.meli.exceptions.NotExistUser;
import com.desafio1.meli.model.*;
import com.desafio1.meli.service.DTO.*;

public interface IUserrepository {
    void loadRepository();
    User findUserById(Integer id);
    Integer countFollower(Integer userId) throws NotExistUser;
    boolean follow(RequestFollowUserToUser requestFollowUserToUser);
    boolean unFollow(RequestUnFollowUserToUser requestUnFollowUserToUser);
    ResponseFollowersListDTO listFollower(Integer userId) throws NotExistUser;
    ResponseFollowsListDTO listFollow(Integer userId) throws NotExistUser;
}
