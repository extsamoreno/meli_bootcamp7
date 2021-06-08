package com.meli.SocialMeli.repository;

import com.meli.SocialMeli.dto.UserNewDto;
import com.meli.SocialMeli.mapper.UserMapper;
import com.meli.SocialMeli.model.Follow;
import com.meli.SocialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository implements IUserRepository{
    @Override
    public void newUser(User user) {
        Tables.newUser(user);
    }

    @Override
    public void follow(Follow follow) {
        Tables.follow(follow);
    }

    @Override
    public User getUserById(int id) {
        return Tables.getUserById(id);
    }

    @Override
    public ArrayList<User> getFollowers(int id) {
        return Tables.getFollowers(id);
    }

    @Override
    public ArrayList<User> getFolloweds(int id) {
        return Tables.getFolloweds(id);
    }
}
