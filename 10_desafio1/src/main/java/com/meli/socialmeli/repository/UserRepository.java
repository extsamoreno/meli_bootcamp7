package com.meli.socialmeli.repository;

import com.meli.socialmeli.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    public static Map<Integer, User> users = new HashMap<>();

    /**
     * Checks if the userId entered corresponds or not with an existing user
     *
     * @param userId Corresponding to the user to be verified
     * @return True if userId is Invalid
     */
    public boolean userIdIsNotValid(int userId) {
        return !users.containsKey(userId);
    }

    /**
     * Checks if the entered user follows the entered seller or not
     *
     * @param userId         Corresponding to the user from which you want to verify if you follow the selle
     * @param userIdToFollow Corresponding to the seller from which you want to verify whether or not it is followed by the user
     * @return True if the user follows the seller
     */
    public boolean userContainsFollower(int userId, int userIdToFollow) {
        return users.get(userIdToFollow).getFollowers().containsKey(userId);
    }

    /**
     * Inserts a new follower. This performs two actions:
     * 1) In the user who will be a follower, a new followed user is inserted
     * 2) In the user that is followed, a new follower is inserted
     *
     * @param userId         Corresponding to the user who will follow another
     * @param userIdToFollow Corresponding to the user to be followed
     */
    public void insertFollower(int userId, int userIdToFollow) {

        User follower = users.get(userId);
        User followed = users.get(userIdToFollow);

        assert followed != null;
        followed.getFollowers().put(userId, follower);
        follower.getFollowed().put(userIdToFollow, followed);
    }

    /**
     * Removes a follower.This performs two actions:
     * 1) In the user who will unfollow, the followed user is deleted
     * 2) In the user that will stop being followed, the follower is deleted
     *
     * @param userId           Corresponding to the user who will unfollow another
     * @param userIdToUnfollow Corresponding with the user who will be unfollowed
     */
    public void removeFollower(int userId, int userIdToUnfollow) {

        User follower = users.get(userId);
        User followed = users.get(userIdToUnfollow);

        followed.getFollowers().remove(userId);
        follower.getFollowed().remove(userIdToUnfollow);
    }

    /**
     * Obtains the number of followers a user has
     *
     * @param userId Corresponding to the user from which you want to obtain the followers count
     * @return The number of followers a user has
     */
    public int getNumberOfFollowers(int userId) {
        return users.get(userId).getFollowers().size();
    }

    /**
     * Obtains a User, which it searches by userId
     *
     * @param userId Corresponding to the user who wants to be obtained
     * @return The User found
     */
    public User getUserById(int userId) {
        return users.get(userId);
    }
}
