package com.socialmeli.socialmeli.repositories;
import com.socialmeli.socialmeli.models.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepositoryImpl implements UserRepository{

    HashMap<Integer, User> users = new HashMap<>();

    public UserRepositoryImpl(){
        users.put(1235,new User(1235,new ArrayList<>(),new ArrayList<>()));
        users.put(1569,new User(1569,new ArrayList<>(),new ArrayList<>()));
    }

    public void addFollowerToUser(int userId,int userIdToFollow){
        users.get(userId).getFollows().add(userIdToFollow);
        users.get(userIdToFollow).getFollowers().add(userId);
    }

    public User getUserById(int userId){
        return users.get(userId);
    }



}
