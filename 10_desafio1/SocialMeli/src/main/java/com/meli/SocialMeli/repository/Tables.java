package com.meli.SocialMeli.repository;

import com.meli.SocialMeli.model.Follow;
import com.meli.SocialMeli.model.User;

import java.util.ArrayList;


public class Tables {
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Follow> followList = new ArrayList<>();

    public static void newUser(User newUser){
        newUser.setUserId(nextUserId());
        userList.add(newUser);
    }

    public static void follow(Follow follow){
        follow.setId(nextFollowId());
        followList.add(follow);
    }

    private static int nextUserId(){
        int id=1;
        if(userList.size()>0){
            id=userList.get(userList.size()-1).getUserId()+1;
        }
        return id;
    }

    private static int nextFollowId(){
        int id=1;
        if(followList.size()>0){
            id=followList.get(followList.size()-1).getId()+1;
        }
        return id;
    }

    public static User getUserById(int id){
        for(User user : userList){
            if(user.getUserId()==id){
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getFollowers(int id) {
        ArrayList<User> followerList = new ArrayList<>();
        for(Follow follow : followList){
            if(follow.getFollowedId()==id){
                followerList.add(getUserById(follow.getFollowerId()));
            }
        }
        return followerList;
    }

    public static ArrayList<User> getFolloweds(int id) {
        ArrayList<User> followedList = new ArrayList<>();
        for(Follow follow : followList){
            if(follow.getFollowerId()==id){
                followedList.add(getUserById(follow.getFollowedId()));
            }
        }
        return followedList;
    }
}
