package com.example.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private List<User> followed;
    private List<User> followers;
    private List<Publication> posts;

    public void addFollowers(User user) {
        int temp = 0;
        for (User obj : followers) {
            if (obj == user) {
                temp++;
            }
        }
        if (temp == 0) {
            followers.add(user);
        }
    }
    public void addFollowed(User user) {
        int temp = 0;
        for (User obj : followed) {
            if (obj == user) {
                temp++;
            }
        }
        if (temp == 0) {
            followed.add(user);
        }
    }
    public void removeFollowers(User user) {
        int temp = 0;
        for (User obj : followers) {
            if (obj == user) {
                temp++;
            }
        }
        if (temp != 0) {
            followers.remove(user);
        }
    }
    public void removeFollowed(User user) {
        int temp = 0;
        for (User obj : followed) {
            if (obj == user) {
                temp++;
            }
        }
        if (temp != 0) {
            followed.remove(user);
        }
    }
}
