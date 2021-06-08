package com.meli.socialmeli.repository;

import com.meli.socialmeli.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    static Map<Integer, User> users = new HashMap<>();

    static {
        users.put(1, new User("user_1", new HashMap<>(), new HashMap<>()));
        users.put(2, new User("user_2", new HashMap<>(), new HashMap<>()));
        users.put(3, new User("user_3", new HashMap<>(), new HashMap<>()));
        users.put(1547, new User("merchant_1547", new HashMap<>(), new HashMap<>()));
        users.put(6684, new User("merchant_6684", new HashMap<>(), new HashMap<>()));
    }

    public boolean userIdIsNotValid(int userId) {
        return !users.containsKey(userId);
    }

    public boolean userAlreadyContainsFollower(int userId, int userIdToFollow) {
        return users.get(userIdToFollow).getFollowers().containsKey(userId);
    }

    public void insertFollower(int userId, int userIdToFollow) {

        // Obtengo el follower específico:
        User follower = users.get(userId);

        // Obtengo el followed específico:
        User followed = users.get(userIdToFollow);

        // Agrego el follower dentro del listado de followers del followed:
        assert followed != null;
        followed.getFollowers().put(userId,follower);

        // Agrego el followed dentro del listado de followed del follower:
        follower.getFollowed().put(userIdToFollow,followed);

    }

    public int getNumberOfFollowers(int userId){
        return users.get(userId).getFollowers().size();
    }

    public User getUserById(int userId){
        return users.get(userId);
    }



}
