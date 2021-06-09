package com.example.desafiospring.socialmeli.repository;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Post;
import com.example.desafiospring.socialmeli.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    HashMap<Integer, User> users = new HashMap<>();

    public UserRepositoryImpl(){
        users.put(0000,new User(0000,"Pablo",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        users.put(1111,new User(1111,"Pepito",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
    }

    @Override
    public void addFollowerToUser(int userId,int userIdToFollow){
        User user1 = getUserById(userId);
        User user2 = getUserById(userIdToFollow);
        users.get(userId).getFollowed().add(user2);
        users.get(userIdToFollow).getFollowers().add(user1); //agrego followers a un user, interactuo entre los 2 creados.
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

    @Override
    public void insertPost(Post post) throws UserNotFoundException {
        User user = getUserById(post.getUserId());
        users.get(user.getUserId()).getPosts().add(post);

    }
}