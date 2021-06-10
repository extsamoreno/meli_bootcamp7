package com.socialmeli.desafio.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerModel {

    private int userId;
    private String userName;
    private ArrayList<PostModel> posts;
    private ArrayList<UserModel> followers;

    public void addFollower(UserModel follower){  //Agrego un usuario que sigue a este vendedor
        this.followers.add(follower);

    }

    public void addPost(PostModel publicacion){
        this.posts.add(publicacion);
    }


    public void removeFollower(UserModel follower){
        this.followers.remove(follower);

    }


}
