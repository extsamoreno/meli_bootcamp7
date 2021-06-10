package com.example.socialmeli.models;

import com.example.socialmeli.models.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class User {
    private int userId;
    private String userName;
    private ArrayList<UserList> followers;
    private ArrayList<UserList> followed;
    private ArrayList<Post> posts;

    public User(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.userName = userDTO.getUserName();
        this.followed = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public User(int userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public void addFollower (UserList user){
        this.followers.add(user);
    }

    public void addFollowed (UserList user){
        this.followed.add(user);
    }

    public void deleteFollower (UserList user) {
        this.followers.remove(user);
    }

    public void deleteFollowed (UserList user) {
        this.followed.remove(user);
    }

    public void addPost(Post post){
        this.posts.add(post);
    }
}
