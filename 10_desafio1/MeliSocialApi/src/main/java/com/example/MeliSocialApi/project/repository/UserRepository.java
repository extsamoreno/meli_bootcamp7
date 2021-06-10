package com.example.MeliSocialApi.project.repository;

import com.example.MeliSocialApi.project.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class UserRepository implements IUserRepository {
    private static Map<Integer, User> users = new HashMap<Integer, User>();

    static {
        User user1 = new User(1,"Juan");
        User user2 = new User(2,"Rodrigo");
        User user3 = new User(3,"Pablo");
        User user4 = new User(4,"Tomas");
        User user5 = new User(5,"tomy");
        User user6 = new User(6,"tomman");
        User user7 = new User(7,"TERRY");
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);
        users.put(user4.getId(), user4);
        users.put(user5.getId(), user5);
        users.put(user6.getId(), user6);
        users.put(user7.getId(), user7);
        user1.getFollowing().add(user2.getId());
        user2.getFollowers().add(user1.getId());
        user1.getFollowing().add(user3.getId());
        user3.getFollowers().add(user1.getId());
        user1.getFollowing().add(user4.getId());
        user4.getFollowers().add(user1.getId());
        user2.getFollowing().add(user1.getId());
        user1.getFollowers().add(user2.getId());
        user4.getFollowing().add(user3.getId());
        user3.getFollowers().add(user4.getId());
        user4.getFollowing().add(user2.getId());
        user2.getFollowers().add(user4.getId());
    }
    // 1-> 2,3,4 // 2 -> 1 // 4 -> 2,3
    public User getUser(Integer id) {
        return users.get(id);
    }
    public Map<Integer, User> getUsers() {
        return users;
    }
}