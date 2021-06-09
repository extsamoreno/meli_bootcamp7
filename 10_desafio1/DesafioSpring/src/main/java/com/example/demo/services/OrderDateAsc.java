package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.UserResponseDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderDateAsc implements Order{
    @Override
    public ArrayList<UserResponseDTO> order(ArrayList<UserResponseDTO> userList) {
        return null;
    }

    @Override
    public FollowedPostListResponseDTO order(FollowedPostListResponseDTO postList) {
        Collections.sort(postList.getPosts(), Comparator.comparing(o -> o.getDate()));
        return postList;
    }
}
