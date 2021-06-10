package com.example.demo.services.mappers;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.InvalidDateFormatException;
import com.example.demo.model.Post;
import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(user.getUserId(), user.getUserName());
    }
    public static UserFollowersCountDTO toUserFollowersCountDTO(User user, int count){
        return new UserFollowersCountDTO(user.getUserId(), user.getUserName(),count);
    }
    public static PostWithPromCountDTO toPostWithPromCount(User user, int count){
        return new PostWithPromCountDTO(user.getUserId(), user.getUserName(),count);
    }
    public static PostWithPromListResponseDTO toPostWithPromList(User user, List<Post> postPromList) throws InvalidDateFormatException {

        List<PostWithPromDTO> postWithPromDTOList = new ArrayList<>();
        for(Post post:postPromList){
            postWithPromDTOList.add(PostMapper.toPostWithPromDTO(post));
        }

        return new PostWithPromListResponseDTO(user.getUserId(), user.getUserName(),postWithPromDTOList);
    }
}