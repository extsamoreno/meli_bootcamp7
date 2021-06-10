package com.example.challenge.Models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private List<User> followed;
    private List<User> followers;
    private List<Post> posts;

    public void addFollower(User u) {
        if (!this.followers.contains(u))
            this.followers.add(u);
    }

    public void addFollowed(User u) {
        if (!this.followed.contains(u))
            this.followed.add(u);
    }

    public boolean addNewPost(Post post) {
        for (Post p : this.posts) {
            if (p.getId() == post.getId()) {
                return false;
            }
        }
        this.posts.add(post);
        return true;
    }
}
