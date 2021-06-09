package com.example.demo.model;

import com.example.demo.model.DTO.UserDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class User {

    private int id;
    private String userName;
    private int followersCount;
    private List<UserDTO> followers = new ArrayList<>();
    private List<UserDTO> followed = new ArrayList<>();
    private static int counterId = 1;
    private ArrayList<Post> posts = new ArrayList<>();

    public User (String userName){
        this.id = counterId;
        this.userName = userName;
        User.counterId++;
    }

    public void addFollower(UserDTO user) {
        this.followers.add(user);
        followersCount++;
    }

    public void addFollowed(UserDTO user) {
        this.followed.add(user);
    }

    public void removeFollower(UserDTO user){
        this.followers.remove(user);
        followersCount--;
    }

    public void removeFollowed(UserDTO user){
        this.followed.remove(user);
    }

}
