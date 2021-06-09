package com.desafio1.meli.repository.userRepository;

import com.desafio1.meli.model.*;
import com.desafio1.meli.service.DTO.*;

public interface IUserrepository {
    User findUserById(Integer id);
    Integer countFollower(Integer userId);
    boolean follow(RequestFollowUserToUser requestFollowUserToUser);
    ResponseFollowersListDTO listFollower(Integer userId);
    ResponseFollowsListDTO listFollow(Integer userId);
}
