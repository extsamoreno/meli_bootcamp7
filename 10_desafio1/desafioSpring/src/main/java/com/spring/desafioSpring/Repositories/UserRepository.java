package com.spring.desafioSpring.Repositories;

import com.spring.desafioSpring.Exceptions.UserNotFoundException;
import com.spring.desafioSpring.Models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository{

    private static Map<Integer, User> dbUsers;

    static {
        dbUsers = new HashMap<>();

        User user1 = new User(1, "Juan Garcia", new ArrayList<User>(), new ArrayList<User>());
        User user2 = new User(2, "Matias Lopez", new ArrayList<User>(), new ArrayList<User>());
        User user3 = new User(3, "Jose Rodriguez", new ArrayList<User>(), new ArrayList<User>());
        User user4 = new User(4, "Ana Perez", new ArrayList<User>(), new ArrayList<User>());
        User user5 = new User(5, "Julia Marinez", new ArrayList<User>(), new ArrayList<User>());
        User user6 = new User(6, "Micaela Gimenez", new ArrayList<User>(), new ArrayList<User>());

        ArrayList<User> followedUser1 = new ArrayList<>();
        followedUser1.add(user5);
        user1.setFollowed(followedUser1);

        ArrayList<User> followedUser2 = new ArrayList<>();
        followedUser2.add(user5);
        user2.setFollowed(followedUser2);

        ArrayList<User> followersUser5 = new ArrayList<>();
        followersUser5.add(user1); followersUser5.add(user2);
        user5.setFollowers(followersUser5);

        ArrayList<User> followedUser3 = new ArrayList<>();
        followedUser3.add(user6);
        user3.setFollowed(followedUser3);

        ArrayList<User> followedUser4 = new ArrayList<>();
        followedUser4.add(user6);
        user4.setFollowed(followedUser4);

        ArrayList<User> followersUser6 = new ArrayList<>();
        followersUser6.add(user3); followersUser6.add(user4);
        user6.setFollowers(followersUser6);

        dbUsers.put(1, user1);
        dbUsers.put(2, user2);
        dbUsers.put(3, user3);
        dbUsers.put(4, user4);
        dbUsers.put(5, user5);
        dbUsers.put(6, user6);
    }

    @Override
    public void follow(int userId, int userIdToFollow) throws UserNotFoundException {
        User user = getUser(userId);
        User userToFollow = getUser(userIdToFollow);

        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);
    }


    @Override
    public User getUser(int userId) throws UserNotFoundException {
        User user = dbUsers.get(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        return user;
    }


}
