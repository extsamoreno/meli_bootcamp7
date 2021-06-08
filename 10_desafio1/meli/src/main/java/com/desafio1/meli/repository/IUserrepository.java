package com.desafio1.meli.repository;

import com.desafio1.meli.model.User;
import com.desafio1.meli.service.DTO.RequestFollowUserToUser;

public interface IUserrepository {
    User findUserById(Integer id);
    boolean follow(RequestFollowUserToUser requestFollowUserToUser);
}
