package com.springChallenge.api.repository.entity;

import com.springChallenge.api.controller.exception.product.IDPostAlreadyUsed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Optional;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User>{
    private int userId;
    private String userName;
    private ArrayList<User> sellersFollowed;
    private ArrayList<User> followers;
    private ArrayList<Post> posts;

    public User(int userId, String userName){
        this.userId = userId;
        this.userName = userName;
        this.sellersFollowed = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addSellerFollowed(User user){
        this.sellersFollowed.add(user);
    }

    public void removeSellerFollowed(User user) {this.sellersFollowed.remove(user);}

    public void addFollower(User user) {
        this.followers.add(user);
    }

    public void removeFollower(User user) {
        this.followers.remove(user);
    }

    public void addPost(Post post) throws IDPostAlreadyUsed {
        Optional<Post> postInDB = this.posts.stream().filter(x -> x.getIdPost() == post.getIdPost()).findFirst();
        if (postInDB.isPresent()){
            throw new IDPostAlreadyUsed(post.getIdPost());
        }
        this.posts.add(post);
    }

    public void copyAll(User user){
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.sellersFollowed = user.getSellersFollowed();
        this.followers = user.getFollowers();
        this.posts = user.getPosts();
    }


    @Override
    public int compareTo(User u) {
        return this.getUserName().compareTo(u.getUserName());
    }
}
