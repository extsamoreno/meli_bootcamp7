package com.meli.spring_challenge.repository.follow;

import com.meli.spring_challenge.model.Follow;

import java.util.List;

public interface FollowRepository {
    List<Follow> getAll();
    void save(Follow follow);
    int getMaxID();
    Follow getFollow(int userID);
    Follow getFollow(int userID, int userToFollowID);
    boolean remove(Follow follow);
    List<Follow> getFollowedByUserID(int userID);
}
