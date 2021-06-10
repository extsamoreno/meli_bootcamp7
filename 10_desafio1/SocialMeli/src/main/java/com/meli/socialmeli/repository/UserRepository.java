package com.meli.socialmeli.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    public static Map<Integer, UserModel> users = new HashMap<>();
    // US001
    public void addNewFollower (int userId, int userIdToFollow) {
        // get the id of the follower
        UserModel follower = users.get(userId);
        //... and the one to be followed
        UserModel followedBy = users.get(userIdToFollow);

        // pin it at the map
        followedBy.getFollowers().put(userId, follower);
        // it actually goes both ways (took me a while to get it)
        follower.getFollowedBy().put(userIdToFollow, followedBy);
    }

}
