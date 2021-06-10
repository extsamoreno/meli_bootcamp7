package com.example.desafio1.repositories;

import com.example.desafio1.exceptions.FollowingDoesNotExistException;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.models.Following;
import com.example.desafio1.models.MeliUser;
import com.example.desafio1.services.utils.UserUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository{
    List<Following> followingsList = new ArrayList<>();

    @Override
    public void addFollowing(int userId, int userIdToFollow) {
        followingsList.add(new Following(userIdToFollow,userId));
    }

    @Override
    public MeliUser getUserById(int userId) {
        ArrayList<MeliUser> users = loadDatabase();
        return users.stream().filter(user -> userId == user.getUserId()).findFirst().orElse(null);
    }

    @Override
    public List<MeliUser> getFollowers(int userId, String order) throws OrderNotValidException {
        List<MeliUser> followers = new ArrayList<>();

        for (Following follow : followingsList) {
            if(follow.getUserIdFollowed() == userId)
                followers.add(getUserById(follow.getUserIdFollower()));
        }
        UserUtil.sort(followers,order);

        return followers;
    }

    @Override
    public List<MeliUser> getFollowed(int userId, String order) throws OrderNotValidException {
        List<MeliUser> followed = new ArrayList<>();

        for (Following follow : followingsList) {
            if(follow.getUserIdFollower() == userId)
                followed.add(getUserById(follow.getUserIdFollowed()));
        }
        UserUtil.sort(followed, order);

        return followed;
    }

    @Override
    public boolean doesFollowingExist(int userId, int userIdFollowed){
        return followingsList.stream().anyMatch(elem -> elem.getUserIdFollower() == userId && elem.getUserIdFollowed() == userIdFollowed);
    }

    @Override
    public void removeFollowing(int userId, int userIdToUnfollow) throws FollowingDoesNotExistException {
        Optional<Following> fol = followingsList.stream().filter(elem -> elem.getUserIdFollowed() == userIdToUnfollow && elem.getUserIdFollower() == userId).findFirst();
        fol.ifPresent(following -> followingsList.remove(following));
    }

    private ArrayList<MeliUser> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<MeliUser>> typeRef = new TypeReference<>() {};
        ArrayList<MeliUser> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
