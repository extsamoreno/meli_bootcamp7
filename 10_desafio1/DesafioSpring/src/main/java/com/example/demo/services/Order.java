package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.UserResponseDTO;

import java.util.ArrayList;

public interface Order {
    ArrayList<UserResponseDTO> order(ArrayList<UserResponseDTO> userList);
    FollowedPostListResponseDTO order(FollowedPostListResponseDTO postList);
}
