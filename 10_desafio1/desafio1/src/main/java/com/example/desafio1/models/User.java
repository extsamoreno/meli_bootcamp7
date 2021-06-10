package com.example.desafio1.models;

import com.example.desafio1.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private List<Integer> followed;
    private List<Integer> followers;
    private List<Post> posts;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followed = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public User(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.userName = userDTO.getUserName();
        this.followed = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addFollower(int userId) {
        this.followers.add(userId);
    }

    public void removeFollower(Integer userId) {
        this.followers.remove(userId);
    }

    public void addFollowed(int userId) {
        this.followed.add(userId);
    }

    public void removeFollowed(Integer userId) {
        this.followed.remove(userId);
    }

    public void addNewPost(Post post) {
        this.posts.add(post);
    }
}
