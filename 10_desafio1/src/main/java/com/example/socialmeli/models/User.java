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
    private ArrayList<UserDTO> followers;
    private ArrayList<UserDTO> followed;
    private ArrayList<Post> posts;

    public User(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.userName = userDTO.getUserName();
        this.followed = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addFollower (UserDTO user){
        this.followers.add(user);
    }

    public void addFollowed (UserDTO user){
        this.followed.add(user);
    }

    public void deleteFollower (UserDTO user) {
        this.followers.remove(user);
    }

    public void deleteFollowed (UserDTO user) {
        this.followed.remove(user);
    }
}
