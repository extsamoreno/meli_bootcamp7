package com.example.desafio1.service.mapper;


import com.example.desafio1.model.User;
import com.example.desafio1.service.dto.userdto.*;

import java.util.ArrayList;

public class UserMapper {
    public static FollowersCountDTO toFollowersCountDTO(User user, int counter)
    {
        return new FollowersCountDTO(user.getId(), user.getName(), counter);
    }

    public static FollowerDTO toFollowerDTO(User user)
    {
        return new FollowerDTO(user.getId(), user.getName());
    }

    public static FollowersListDTO toFollowersListDTO(User user, ArrayList<FollowerDTO> followerDTOs)
    {
        return new FollowersListDTO(user.getId(), user.getName(), followerDTOs);
    }

    public static FollowedDTO toFollowedDTO(User user)
    {
        return new FollowedDTO(user.getId(), user.getName());
    }

    public static FollowedListDTO toFollowedListDTO(User user, ArrayList<FollowedDTO> followedDTOs)
    {
        return new FollowedListDTO(user.getId(), user.getName(), followedDTOs);
    }
}
