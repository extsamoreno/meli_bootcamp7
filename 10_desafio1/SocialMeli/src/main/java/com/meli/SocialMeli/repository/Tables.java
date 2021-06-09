package com.meli.SocialMeli.repository;

import com.meli.SocialMeli.exception.RepeatedFollowUserException;
import com.meli.SocialMeli.model.Follow;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
import com.meli.SocialMeli.model.User;

import java.util.ArrayList;


public class Tables {
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Follow> followList = new ArrayList<>();
    private static ArrayList<Post> postList = new ArrayList<>();
    private static ArrayList<Product> productList = new ArrayList<>();

    public static void newUser(User newUser){
        newUser.setUserId(nextUserId());
        userList.add(newUser);
    }

    public static void follow(Follow follow){
        follow.setId(nextFollowId());
        followList.add(follow);
    }

    public static void editFollow(Follow follow){
        for (int i = 0; i < followList.size(); i++) {
            if(followList.get(i).getId()==follow.getId()){
                followList.set(i,follow);
            }
        }
    }

    private static int nextUserId(){
        int id=1;
        if(userList.size()>0){
            id=userList.get(userList.size()-1).getUserId()+1;
        }
        return id;
    }

    private static int nextFollowId(){
        int id=1;
        if(followList.size()>0){
            id=followList.get(followList.size()-1).getId()+1;
        }
        return id;
    }

    public static User getUserById(int id){
        for(User user : userList){
            if(user.getUserId()==id){
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getFollowers(int id) {
        ArrayList<User> followerList = new ArrayList<>();
        for(Follow follow : followList){
            if(follow.getFollowedId()==id && follow.isActive()){
                followerList.add(getUserById(follow.getFollowerId()));
            }
        }
        return followerList;
    }

    public static ArrayList<User> getFolloweds(int id) {
        ArrayList<User> followedList = new ArrayList<>();
        for(Follow follow : followList){
            if(follow.getFollowerId()==id && follow.isActive()){
                followedList.add(getUserById(follow.getFollowedId()));
            }
        }
        return followedList;
    }

    public static Follow getFollow(int idFollower, int idFollowed){
        for(Follow check : followList){
            if(check.getFollowerId()==idFollower && check.getFollowedId()==idFollowed && check.isActive()){
                return check;
            }
        }
        return null;
    }

    public static void newPost(Post post) {
        post.setId(nextPostId());
        postList.add(post);
    }

    public static int newProduct(Product product) {
        product.setId(nextProductId());
        productList.add(product);
        return product.getId();
    }

    private static int nextPostId(){
        int id=1;
        if(postList.size()>0){
            id=postList.get(postList.size()-1).getId()+1;
        }
        return id;
    }

    private static int nextProductId(){
        int id=1;
        if(productList.size()>0){
            id=productList.get(productList.size()-1).getId()+1;
        }
        return id;
    }

    public static ArrayList<Post> getPostByUser(int userId) {
        ArrayList<Post> retPostList = new ArrayList<>();
        for(Post post : postList){
            if(post.getUserId()==userId){
                retPostList.add(post);
            }
        }
        return retPostList;
    }

    public static Product getProductById(int productId) {
        for(Product product : productList){
            if(product.getId()==productId){
                return product;
            }
        }
        return null;
    }
}
