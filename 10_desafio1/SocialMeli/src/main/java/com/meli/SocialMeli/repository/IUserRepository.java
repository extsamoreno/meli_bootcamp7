package com.meli.SocialMeli.repository;

import com.meli.SocialMeli.model.Follow;
import com.meli.SocialMeli.model.User;

import java.util.ArrayList;

public interface IUserRepository {
    void newUser(User user);

    void follow(Follow follow);

    void editFollow(Follow follow);

    User getUserById(int id);

    ArrayList<User> getFollowers(int id);

    ArrayList<User> getFolloweds(int id);

    Follow getFollow(int idFollower, int idFollowed);
}
