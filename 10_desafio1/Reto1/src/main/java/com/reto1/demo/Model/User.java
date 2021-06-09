package com.reto1.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements IUser {
    int id;
    String name;
    ArrayList<IUser> followers = new ArrayList<>();
    ArrayList<IUser> followed = new ArrayList<>();
    ArrayList<Post> posts = new ArrayList<>();

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public void followPages(IUser iuser) {
        followed.add(iuser);
    }

    @Override
    public void addFollower(IUser follower) {
        followers.add(follower);
    }

    @Override
    public void unFollowPages(IUser iuser) {
        followed.remove(iuser);
    }

    @Override
    public void removeFollower(IUser follower) {
        followers.remove(follower);
    }

    public void addPost(Post post){
        posts.add(post);
    }
}
