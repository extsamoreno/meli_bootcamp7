package com.example.demo.project.service.mapper;

import com.example.demo.project.models.User;
import com.example.demo.project.service.dto.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public SellerDTO toSellerDTO(User user, List<User> followers){
        List<UserDTO> followersDTO = new ArrayList<>();
        for (User follower: followers) {
            followersDTO.add(toUserDTO(follower));
        }

        return new SellerWithFollowersDTO(user.getName(), user.getId(), user.getFollowers_count(), followersDTO);
    }

    public SellerDTO toSellerDTO(User user){
        return new SellerDTO(user.getName(), user.getId(), user.getFollowers_count());
    }

    public UserDTO toUserWithFollowingDTO(User user, List<User> following){
        List<UserDTO> followingDTO = new ArrayList<>();
        for (User follow: following) {
            followingDTO.add(toUserDTO(follow));
        }

        return new UserWithFollowingListDTO(user.getName(), user.getId(), user.getFollowing_count(), followingDTO);
    }

    public UserDTO toUserWithFollowingDTO(User user){
        return new UserWithFollowingCountDTO(user.getName(), user.getId(), user.getFollowing_count());
    }

    public UserDTO toUserDTO(User user){
        return new UserDTO(user.getName(), user.getId());
    }
}
