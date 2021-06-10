package com.SocialMeli.repositories;

import com.SocialMeli.controller.UserController;
import com.SocialMeli.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class UserRepository implements IUserRepository{

    private static Map<Integer, User> dbUsers;

    static {
        dbUsers = new HashMap<>();

        User user1 = new User(1,"Seller Ñuñoa", new ArrayList<User>(), new ArrayList<>());
        User user2 = new User(2,"Seller Provi", new ArrayList<User>(), new ArrayList<>());
        User user3 = new User(3,"Seller Maipu", new ArrayList<User>(), new ArrayList<>());
        User user4 = new User(4,"Seller Stgo", new ArrayList<User>(), new ArrayList<>());

        ArrayList<User> followedUser1 = new ArrayList<>();
        followedUser1.add(user4);
        user1.setFollowed(followedUser1);

        ArrayList<User> followedUser2 = new ArrayList<>();
        followedUser1.add(user3);
        user1.setFollowed(followedUser1);

        ArrayList<User> followedUser3 = new ArrayList<>();
        followedUser1.add(user1);
        user1.setFollowed(followedUser1);

        ArrayList<User> followedUser4 = new ArrayList<>();
        followedUser1.add(user2);
        user1.setFollowed(followedUser1);

        dbUsers.put(1, user1);
        dbUsers.put(2, user2);
        dbUsers.put(3, user3);
        dbUsers.put(4, user4);

    }


    @Override
    public User addFollowUserDTO(int userId, int userIdToFollow) throws UnhandledException {
        return null;
    }

    @Override
    public User findUserById(int userId) throws UnhandledException {
        return null;
    }

    @Override
    public ArrayList<User> findFollowersByUserId(int userId) throws UnhandledException {
        return null;
    }

    @Override
    public ArrayList<User> findFollowedByUserId(int userId) throws UnhandledException {
        return null;
    }

    @Override
    public Boolean follow(Integer userID, Integer useridtofollow) {
        return (Boolean.TRUE);
    }

    @Override
    public Stream<User> getUserFollowersById(int userId) {
        return null;
    }
}
