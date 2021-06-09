package com.meli.socialmeli.model;

import com.meli.socialmeli.dto.UserFollowerDTO;
import com.meli.socialmeli.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
public class UserMeli {
    private int userId;
    private String userName;
    private ArrayList<Integer> followers = new ArrayList<>();
    private ArrayList<Integer> followedBy = new ArrayList<>();

    public UserMeli(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

//    public Collection<Object> getFollowed() {
//    }

    //private String followed;
    //private String followers;
}
