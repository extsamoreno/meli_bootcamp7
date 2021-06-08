package com.meli.socialmeli.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;

    private List<User> followers;
    private List<User> followed;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
    }

    public void startToFollow(User userToFollow) {
        this.addToFollowed(userToFollow);
        userToFollow.addToFollowers(this);
    }

    public void addToFollowers(User follower) {
        followers.add(follower);
    }

    public void removeFromFollowers(User follower) {
        followers.remove(follower);
    }

    public void addToFollowed(User userToFollow) {
        followed.add(userToFollow);
    }

    public void removeFromFollowed(User userToUnFollow) {
        followed.remove(userToUnFollow);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
