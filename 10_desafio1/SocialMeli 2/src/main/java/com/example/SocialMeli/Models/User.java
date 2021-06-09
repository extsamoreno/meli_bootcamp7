package com.example.SocialMeli.Models;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {

    private int id;
    private String name;
    private List<Integer> followers;
    private List<Integer> following;
    private List<Integer> posts;


    public void addFollower(int userId){
        if(this.followers.indexOf(userId) == -1){
            this.followers.add(userId);
        }

    }

    public void addFollowed(int userId){
        if(this.following.indexOf(userId) == -1){
            this.following.add(userId);
        }

    }
    public void unfollow(int userId){
        int index = this.following.indexOf(userId);
        if(index != -1){
            this.following.remove(index);
        }

    }
    public void unfollowed(int userId){
        int index = this.followers.indexOf(userId);
        if(index != -1){
            this.followers.remove(index);
        }

    }
    public void addPost(int postId){

        this.posts.add(postId);
    }
}
