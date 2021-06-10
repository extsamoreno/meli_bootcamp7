package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.PostDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.exceptions.InvalidDateFormatException;
import com.example.demo.model.Post;
import com.example.demo.services.mappers.PostMapper;

import java.util.ArrayList;
import java.util.Collections;

public class OrderDateDesc implements Order{
    @Override
    public ArrayList<UserResponseDTO> order(ArrayList<UserResponseDTO> userList) {
        return userList;
    }

    @Override
    public ArrayList<PostDTO> orderDate(ArrayList<Post> postList) throws InvalidDateFormatException {
        ArrayList<PostDTO> postListDTO = new ArrayList<>();
        postList.sort((d1, d2) -> d2.getDate().compareTo(d1.getDate()));
        for(Post post:postList){
            postListDTO.add(PostMapper.toPostDTO(post));
        }
        return postListDTO;
    }

}
