package com.meli.socialmeli.models;

import com.meli.socialmeli.dto.UserFollowerDTO;
import com.meli.socialmeli.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMeli {

    private int userId;
    private String userName;
    private ArrayList<Integer> followers = new ArrayList<>();
    private ArrayList<Integer> followedBy = new ArrayList<>();

    public UserMeli(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
<<<<<<< HEAD:10_desafio1/socialmeli/src/main/java/com/meli/socialmeli/models/UserMeli.java
=======

//    public Collection<Object> getFollowed() {
//    }

    //private String followed;
    //private String followers;
>>>>>>> 97ccd39f43a35ef07d0dfa9228f1ac61e497f5b6:10_desafio1/socialmeli/src/main/java/com/meli/socialmeli/model/UserMeli.java
}
