package com.socialmedia.socialmedia.mappers;

import com.socialmedia.socialmedia.repositories.entities.User;
import com.socialmedia.socialmedia.services.dtos.UserCountFollowerDTO;
import com.socialmedia.socialmedia.services.dtos.UserDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowersDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserCountFollowerDTO UserToUserCountFollowerDTO(User user) {
        UserCountFollowerDTO result = new UserCountFollowerDTO();

        result.setId(user.getId());
        result.setUsername(user.getNickname());
        result.setFollowers(user.getFollowers().size());

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
}
