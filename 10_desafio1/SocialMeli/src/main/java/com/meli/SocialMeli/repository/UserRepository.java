package com.meli.SocialMeli.repository;

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
    public void editFollow(Follow follow) {
        Tables.editFollow(follow);
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

    @Override
    public Follow getFollow(int idFollower, int idFollowed) {
        return Tables.getFollow(idFollower,idFollowed);
    }
}
