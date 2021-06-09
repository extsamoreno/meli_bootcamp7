package com.example.MeliSocialApi.project.repository;

import com.example.MeliSocialApi.project.model.User;

import java.util.Map;

public interface IUserRepository {
    User getUser(Integer id);
    Map<Integer, User> getUsers();
}
