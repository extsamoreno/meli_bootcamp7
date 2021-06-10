package com.meli.SocialMeli.repository;

import com.meli.SocialMeli.dto.CreateUserDto;
import com.meli.SocialMeli.models.User;

import java.util.List;

public interface IUserRepository {
    List<User> CreateUser(CreateUserDto createUserDto);

    public User SearchIdUser(int idUser);
    public void UpdateUserList(User user);

    List<User> getUsers();
    int FollowUser(int userId, int userIdToFollow);
}
