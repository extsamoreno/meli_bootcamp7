package com.example.challenge.Models;

import com.example.challenge.Services.DTOs.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private List<User> followed;
    private List<User> followers;
    private List<Post> posts;

    public void addFollower(User u) {
        boolean exist = false;
        for (User usr : this.followers) {
            if (usr == u) {
                exist = true;
            }
        }
        if (!exist)
            this.followers.add(u);
    }

    public void addFollowed(User u) {
        boolean exist = false;
        for (User usr : this.followed) {
            if (usr == u) {
                exist = true;
            }
        }
        if (!exist)
            this.followed.add(u);
    }

    public boolean addNewPost(Post post){
        boolean exist = false;
        for (Post p : this.posts) {
            if (p.getId() == post.getId()) {
                exist = true;
            }
        }
        if (!exist)
            this.posts.add(post);

        return !exist;
    }
}
