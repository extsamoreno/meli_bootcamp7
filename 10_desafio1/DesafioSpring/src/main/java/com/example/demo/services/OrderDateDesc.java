package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.UserResponseDTO;

import java.util.ArrayList;
import java.util.Collections;

public class OrderDateDesc implements Order{
    @Override
    public ArrayList<UserResponseDTO> order(ArrayList<UserResponseDTO> userList) {
        return null;
    }

    @Override
    public FollowedPostListResponseDTO order(FollowedPostListResponseDTO postlist) {
        Collections.sort(postlist.getPosts(), (o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        return postlist;
    }
}
