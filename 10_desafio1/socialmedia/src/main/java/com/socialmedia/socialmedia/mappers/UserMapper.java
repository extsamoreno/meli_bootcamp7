package com.socialmedia.socialmedia.mappers;

import com.socialmedia.socialmedia.repositories.entities.User;
import com.socialmedia.socialmedia.services.dtos.*;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserCountFollowerDTO UserToUserCountFollowerDTO(User user) {
        UserCountFollowerDTO result = new UserCountFollowerDTO();

        result.setId(user.getId());
        result.setUsername(user.getNickname());

        return result;
    }

    public static UserWithFollowersDTO UserToUserWithFollowersDTO(User user, List<UserDTO> userList) {
        UserWithFollowersDTO result = new UserWithFollowersDTO();

        result.setId(user.getId());
        result.setUsername(user.getNickname());
        result.setFollowers(userList);

        return result;
    }

    public static List<UserDTO> UsersToUsersDTO(List<User> userList) {
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user :
                userList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getNickname());

            userDTOS.add(userDTO);
        }

        return userDTOS;
    }

    public static UserWithFollowedDTO UserToUserWithFollowedDTO(User user, List<UserDTO> followedDTOs) {
        UserWithFollowedDTO result = new UserWithFollowedDTO();

        result.setId(user.getId());
        result.setUsername(user.getNickname());
        result.setFollowed(followedDTOs);

        return result;
    }

    public static UserWithFollowedPostsDTO UserToUserWithFollowedPostsDTO(User user) {
        UserWithFollowedPostsDTO result = new UserWithFollowedPostsDTO();

        result.setId(user.getId());
        result.setUsername(user.getNickname());
        result.setPosts(new ArrayList<>());

        return result;
    }

    public static UserCountPromoDTO UserToUserCountPromoDTO(User user) {
        var result = new UserCountPromoDTO();

        result.setId(user.getId());
        result.setUsername(user.getNickname());

        return result;
    }

    public static UserWithPromosDTO UserToUserPromoDTO(User user) {
        var result = new UserWithPromosDTO();
        result.setId(user.getId());
        result.setUsername(user.getNickname());
        return result;
    }
}
