package com.example.demo.services;

import com.example.demo.dtos.PostDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.exceptions.InvalidDateFormatException;
import com.example.demo.model.Post;

import java.util.ArrayList;

public interface Order {
    ArrayList<UserResponseDTO> order(ArrayList<UserResponseDTO> userList);
    ArrayList<PostDTO> orderDate(ArrayList<Post> postList) throws InvalidDateFormatException;
}
