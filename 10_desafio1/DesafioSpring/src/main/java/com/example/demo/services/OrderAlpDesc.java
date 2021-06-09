package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.UserResponseDTO;
import java.util.ArrayList;
import java.util.Collections;

public class OrderAlpDesc implements Order{


    @Override
    public ArrayList<UserResponseDTO> order(ArrayList<UserResponseDTO> userList) {
        //Collections.sort(userList, Comparator.comparing(o -> o.getUserName().toLowerCase()));
        Collections.sort(userList, (o1, o2) -> o2.getUserName().toLowerCase().compareTo(o1.getUserName().toLowerCase()));
        return userList;
    }

    @Override
    public FollowedPostListResponseDTO order(FollowedPostListResponseDTO postList) {
        return null;
    }
}
