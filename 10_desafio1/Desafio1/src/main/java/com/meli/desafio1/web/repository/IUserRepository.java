package com.meli.desafio1.web.repository;

import com.meli.desafio1.web.model.Follow;
import com.meli.desafio1.web.model.User;

import java.util.List;

public interface IUserRepository {
    public List<User> getUserList();
}
