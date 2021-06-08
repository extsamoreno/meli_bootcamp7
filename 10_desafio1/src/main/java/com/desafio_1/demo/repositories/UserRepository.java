package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository implements IUserRepository{

        private ArrayList<User> listUsers = new ArrayList<User>(Arrays.asList(
                new User(1,"usuario1", "Santiago Garcia", new ArrayList<User>(), new ArrayList<User>()),
                new User(2,"usuario2", "Juan Perez", new ArrayList<User>(), new ArrayList<User>()),
                new User(3,"usuario3", "Manuel liendo", new ArrayList<User>(), new ArrayList<User>()),
                new User(4,"usuario4", "Melisa Gonzalez", new ArrayList<User>(), new ArrayList<User>()),
                new User(5,"usuario5", "Tomas Colazo", new ArrayList<User>(), new ArrayList<User>())
        ));


    @Override
    public User addFollowUser(Integer userId, Integer userIdToFollow) throws UnhandledException {

        try{
            List<User> users = listUsers;
            User userFollower = users.stream().filter(user -> user.getId() == userId).findFirst().get();
            User userToFollow = users.stream().filter(user -> user.getId() == userIdToFollow).findFirst().get();

            userFollower.getFollowed().add(userToFollow);
            userToFollow.getFollowers().add(userFollower);
            users.set(userFollower.getId() - 1, userFollower);
            users.set(userToFollow.getId() - 1, userToFollow);

            return userFollower;

        }catch (Exception ex){
            throw new UnhandledException(ex.getMessage());
        }

    }


    @Override
    public User findUserById(Integer userId) throws UnhandledException {

        try{
            User user = listUsers.stream()
                    .filter(u -> u.getId() == userId)
                    .findFirst()
                    .orElse(null);
            return user;
        }catch (Exception ex){
            throw new UnhandledException(ex.getMessage());
        }

    }

}
