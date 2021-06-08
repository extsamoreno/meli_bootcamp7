package com.reto1.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements IUser {
    int id;
    String name;
    ArrayList<IUser> followers = new ArrayList<>();
    //ArrayList<IUser> followed;
    ArrayList<Post> posts = new ArrayList<>();

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public void follow(IUser iuser) {
        followers.add(iuser);
    }

    @Override
    public void sell(IProduct iProduct) {
        posts.add(new Post(
                posts.size(),
                LocalDate.now(),
                iProduct));
    }
}
