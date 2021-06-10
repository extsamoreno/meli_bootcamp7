package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.PostDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.model.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderAlpAsc implements Order{

    @Override
    public ArrayList<UserResponseDTO> order(ArrayList<UserResponseDTO> userList) {
        Collections.sort(userList, Comparator.comparing(o -> o.getUserName().toLowerCase()));
        return userList;
    }

    @Override
    public ArrayList<PostDTO> orderDate(ArrayList<Post> postList) {
        return null;
    }


}