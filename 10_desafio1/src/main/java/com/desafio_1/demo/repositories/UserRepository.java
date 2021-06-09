package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
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

    @Override
    public User addFollowUser(int userId, int userIdToFollow) throws UnhandledException {

        try{

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
    public ArrayList<User> findFollowersByUserId(int userId, Comparator<String> c) throws UnhandledException {

        try{
            ArrayList<User> followers = new ArrayList<>();
            List<User> followersFind = listUsers.stream()
                    .filter(u -> u.getId() == userId)
                    .findFirst()
                    .get()
                    .getFollowers()
                    .stream()
                    .sorted((a, b) -> c.compare(a.getUserName(), b.getUserName()))
                    .collect(Collectors.toList());

            followers.addAll(followersFind);
            return followers;
        }catch (Exception ex){
            throw new UnhandledException(ex.getMessage());
        }

    }

    @Override
    public ArrayList<User> findFollowedByUserId(int userId, Comparator<String> c) throws UnhandledException {
        try{
            ArrayList<User> followed = new ArrayList<>();
            List<User> followedFind = listUsers.stream()
                    .filter(u -> u.getId() == userId)
                    .findFirst()
                    .get()
                    .getFollowed()
                    .stream()
                    .sorted((a, b) -> c.compare(a.getUserName(), b.getUserName()))
                    .collect(Collectors.toList());

            followed.addAll(followedFind);
            return followed;
        }catch (Exception ex){
            throw new UnhandledException(ex.getMessage());
        }
    }

}
