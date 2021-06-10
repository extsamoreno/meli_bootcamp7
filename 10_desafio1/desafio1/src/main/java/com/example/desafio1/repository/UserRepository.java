package com.example.desafio1.repository;

import com.example.desafio1.exception.user.UserNotFollowException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepository implements iUserRepository {

    // Map with Users (all users)
    HashMap<Integer, User> mapUsers = new HashMap();

    // Load users to mapUsers
    public UserRepository() {
        loadUsers();
    }

    // Update user data (not used)
    @Override
    public User saveUser(User user) {

        mapUsers.put(user.getUserId(), user);
        return user;
    }

    // Search user by Id
    @Override
    public User findUserById(Integer id) throws UserNotFoundException {

        // Exception: ID doesn't exist
        if (mapUsers.get(id) == null) {
            throw new UserNotFoundException(id);
        }
        return mapUsers.get(id);
    }

    // Unfollow a user
    @Override
    public void unFollowUser(Integer userId, Integer userIdToUnFollow) throws UserNotFoundException, UserNotFollowException {

        User follower = findUserById(userId);
        User followed = findUserById(userIdToUnFollow);

        // Exception: follower doesn't follow that user
        if(!followed.getFollowers().contains(follower)){
            throw new UserNotFollowException(userId, userIdToUnFollow);
        }

        // Remove follower and followed from the users lists
        follower.getFollows().remove(followed);
        followed.getFollowers().remove(follower);
    }

    @Override
    // Load default users, all users can be sellers and buyers
    public void loadUsers() {

        mapUsers.put(0, new User(0, "Tomas", new ArrayList<User>(), new ArrayList<User>()));
        mapUsers.put(1, new User(1, "Carlos", new ArrayList<User>(), new ArrayList<User>()));
        mapUsers.put(2, new User(2, "Agustin", new ArrayList<User>(), new ArrayList<User>()));
        mapUsers.put(3, new User(3, "Mario", new ArrayList<User>(), new ArrayList<User>()));
        mapUsers.put(4, new User(4, "Roberto", new ArrayList<User>(), new ArrayList<User>()));
        mapUsers.put(5, new User(5, "German", new ArrayList<User>(), new ArrayList<User>()));
    }
}
