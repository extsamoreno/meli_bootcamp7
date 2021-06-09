package com.meli.socialmeli.model.dao.model;

import lombok.*;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private boolean isSeller;
    private ArrayList<User> usersFollowed = new ArrayList<>();
    private int cantFollowed = 0;
    private static int counterId = 1;
    private ArrayList<Post> post = new ArrayList<>();

    public User(String userName, boolean isSeller) {
        this.userName = userName;
        this.isSeller = isSeller;
        this.userId = User.counterId;
        User.counterId++;
    }

}