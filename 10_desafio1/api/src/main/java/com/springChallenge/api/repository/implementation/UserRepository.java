package com.springChallenge.api.repository.implementation;

import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.repository.aux.DbLoader;
import com.springChallenge.api.repository.contract.IUserRepository;
import com.springChallenge.api.repository.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final User[] users = DbLoader.loadUsers();

    @Override
    public User getByUserId(int userId) throws UserNotFoundException {
        Optional<User> user = Arrays.stream(users).filter(x -> x.getUserId() == userId).findFirst();
        if (user.isPresent())
            return user.get();
        else
            throw new UserNotFoundException(userId);
    }

    @Override
    public void save(User user) {
        var userInDb = Arrays.stream(users).filter(x -> x.getUserId() == user.getUserId()).findFirst().get();
        userInDb.copyAll(user);
    }
}
