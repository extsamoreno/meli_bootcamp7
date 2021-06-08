package com.example.desafiospring.socialmeli.repository;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    HashMap<Integer, User> users = new HashMap<>();

    public UserRepositoryImpl(){
        users.put(1569,new User(1569,"Pablo",new ArrayList<>(),new ArrayList<>())); //agrego user
    }

    @Override
    public void addFollowerToUser(int userId,int userIdToFollow){
        users.get(userId).getFollows().add(userIdToFollow);
        users.get(userIdToFollow).getFollowers().add(userId);
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        if(users.get(userId) == null){
            throw new UserNotFoundException("El user no existe"); //exception para cdo el user no existe
        }
        return users.get(userId);
    }

    @Override
    public int getFollowersCount(int userId) {
        return users.get(userId).getFollowers().size();
    }


}