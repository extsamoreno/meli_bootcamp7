package com.desafio.SocialMeli.Classes;

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
    private List<User> followers = new ArrayList<>();
    private List<User> followed = new ArrayList<>();

    public User(int userId) {
        this.userId = userId;
    }

    public void setFollowed(User user) {
        this.followed.add(user);
    }

    public void setFollowers(User user) {
        this.followers.add(user);
    }

    public int getFollowersCount() {
        return this.getFollowers().size();
    }
}
