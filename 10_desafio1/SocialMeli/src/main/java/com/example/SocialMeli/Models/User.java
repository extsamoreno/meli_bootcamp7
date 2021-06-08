package com.example.SocialMeli.Models;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {

    private String id;
    private String name;
    private List<String> followers;
    private List<String> followedBy;
    private List<Object> posts;


    public void addFollower(String userId){
        this.followers.add(userId);
    }

    public void addFollowed(String userId){
        this.followedBy.add(userId);
    }
}
