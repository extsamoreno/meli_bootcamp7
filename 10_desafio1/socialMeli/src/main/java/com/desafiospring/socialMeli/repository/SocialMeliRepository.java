package com.desafiospring.socialMeli.repository;

import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {
    HashMap<Integer, User> usersDic = new HashMap<>();

    public SocialMeliRepository() {
        usersDic.put(1, new User("Usuario1", 1, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(2, new User("Usuario2", 2, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(3, new User("Usuario3", 3, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(4, new User("Usuario4", 4, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(5, new User("Usuario5", 5, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(6, new User("Usuario6", 6, new ArrayList<>(), new ArrayList<>()));
    }

    @Override
    public User findUserById(int userId) throws UserNotFoundException {
        if(usersDic.get(userId) == null) {
            throw new UserNotFoundException(userId);
        }
        return usersDic.get(userId);
    }


    @Override
    public void addFollowerToUser(int userId, int userIdToFollow) throws UserNotFoundException {
        usersDic.get(userId).getFollowers().add(findUserById(userIdToFollow));
        usersDic.get(userIdToFollow).getFollowedBy().add(findUserById(userId));
    }

    @Override
    public int getFollowersCount(int userId) {
        return usersDic.get(userId).getFollowedBy().size();
    }

}