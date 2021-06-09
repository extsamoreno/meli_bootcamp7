package com.example.demo.services.mapper;

import com.example.demo.model.DTO.*;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Mapper {

    public FollowersListDTO toFollowersListDTO(String userName, int id, List<UserDTO> followers){
        return new FollowersListDTO(userName, id, followers);
    }

    public FollowedListDTO toFollowedListDTO(String userName, int id, List<UserDTO> followed){
        return new FollowedListDTO(userName, id, followed);
    }

    public ResponseCountDTO toCountDTO(int id, String username, int i){
        return new ResponseCountDTO(username, id, i);
    }

    public UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getUserName());
    }

    public UserPostsDTO toUserPostsDTO(int id, ArrayList<Post> posts){
        return new UserPostsDTO(id, posts);
    }

}
