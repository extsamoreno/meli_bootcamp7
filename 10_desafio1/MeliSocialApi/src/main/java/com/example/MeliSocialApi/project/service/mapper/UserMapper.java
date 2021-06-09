package com.example.MeliSocialApi.project.service.mapper;

import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.service.dto.FollowedUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserFollowersCountDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserDTOResponse;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class UserMapper {
    public static FollowersUserDTOResponse userToFollowersUserDTO(User user, LinkedList<User> followers){
        LinkedList<UserDTOResponse> followersDTO = new LinkedList<>();
        for (User userAux : followers){
            followersDTO.add(new UserDTOResponse(userAux.getId(), userAux.getName()));
        }
        return new FollowersUserDTOResponse(user,followersDTO);
    }
    public static FollowedUserDTOResponse userToFollowedUserDTO(User user, LinkedList<User> followers){
        LinkedList<UserDTOResponse> followersDTO = new LinkedList<>();
        for (User userAux : followers){
            followersDTO.add(new UserDTOResponse(userAux.getId(), userAux.getName()));
        }
        return new FollowedUserDTOResponse(user,followersDTO);
    }
    public static UserFollowersCountDTOResponse userToUserFollowersCountDTO(User user){
        return new UserFollowersCountDTOResponse(user,(user.getFollowers().size()));
    }
}
