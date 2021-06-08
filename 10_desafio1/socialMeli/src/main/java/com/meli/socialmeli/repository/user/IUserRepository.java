package com.meli.socialmeli.repository.user;

import com.meli.socialmeli.domain.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findUserById(Integer userId);

    void save(User user);
}
