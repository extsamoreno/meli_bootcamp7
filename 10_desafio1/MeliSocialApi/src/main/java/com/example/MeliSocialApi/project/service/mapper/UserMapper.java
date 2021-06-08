package com.example.MeliSocialApi.project.service.mapper;

import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserFollowersCountDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserDTOResponse;

import java.util.LinkedHashSet;

public class UserMapper {
    public static FollowersUserDTOResponse userToFollowersUserDTO(User user, LinkedHashSet<User> followers){
        LinkedHashSet<UserDTOResponse> followersDTO = new LinkedHashSet<>();
        for (User userAux : followers){
            followersDTO.add(new UserDTOResponse(userAux.getId(), userAux.getName()));
        }
        return new FollowersUserDTOResponse(user,followersDTO);
    }
    public static UserFollowersCountDTOResponse userToUserFollowersCountDTO(User user){
        return new UserFollowersCountDTOResponse(user,(user.getFollowers().size()));
    }
}
