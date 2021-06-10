package com.example.demo.services;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.PostDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.exceptions.InvalidDateFormatException;
import com.example.demo.model.Post;
import com.example.demo.services.mappers.PostMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderAlpDesc implements Order{


    @Override
    public ArrayList<UserResponseDTO> order(ArrayList<UserResponseDTO> userList) {
        //Collections.sort(userList, Comparator.comparing(o -> o.getUserName().toLowerCase()));
        Collections.sort(userList, (o1, o2) -> o2.getUserName().toLowerCase().compareTo(o1.getUserName().toLowerCase()));
        return userList;
    }

    @Override
    public ArrayList<PostDTO> orderDate(ArrayList<Post> postList) throws InvalidDateFormatException {
        ArrayList<PostDTO> postListDTO = new ArrayList<>();
        postList.sort(Comparator.comparing(Post::getDate));
        for(Post post:postList){
            postListDTO.add(PostMapper.toPostDTO(post));
        }
        return postListDTO;
    }

}
