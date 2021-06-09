package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.Follow;
import com.desafio_1.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

        private ArrayList<User> listUsers = new ArrayList<User>(Arrays.asList(
                new User(1,"santiigarcia1", new ArrayList<User>(), new ArrayList<User>()),
                new User(2,"juanpe", new ArrayList<User>(), new ArrayList<User>()),
                new User(3,"manufaliendo", new ArrayList<User>(), new ArrayList<User>()),
                new User(4,"meligonzalez", new ArrayList<User>(), new ArrayList<User>()),
                new User(5,"tomicol",new ArrayList<User>(), new ArrayList<User>())
        ));

        private ArrayList<Follow> listFollows = new ArrayList<>();

    @Override
    public User addFollowUser(int userId, int userIdToFollow) throws UnhandledException {

        try{
            listFollows.add(new Follow(listFollows.size() + 1, userId, userIdToFollow));

            List<User> users = listUsers;
            User userFollower = users.stream().filter(user -> user.getId() == userId).findFirst().orElse(null);
            User userToFollow = users.stream().filter(user -> user.getId() == userIdToFollow).findFirst().orElse(null);

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
    public User findUserById(int userId) throws UnhandledException {

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

    @Override
    public ArrayList<User> findFollowersByUserId(int userId) throws UnhandledException {

        try{
            ArrayList<User> followers = listUsers.stream()
                    .filter(u -> u.getId() == userId)
                    .findFirst()
                    .get()
                    .getFollowers();

            return followers;
        }catch (Exception ex){
            throw new UnhandledException(ex.getMessage());
        }

    }

}
