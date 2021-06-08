package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.DTO.UserAmountFollowersDTO;
import com.bootcamp.socialmeli.DTO.UserDTO;
import com.bootcamp.socialmeli.DTO.UserFollowedListDTO;
import com.bootcamp.socialmeli.DTO.UserFollowersListDTO;
import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserAmountFollowersDTO toUserAmountFollowersDTO(User user) {
        return new UserAmountFollowersDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

    public UserFollowersListDTO toListUserFollowersDTO(User user, List<User> followers) {

        List<UserDTO> followersDTO = followers
                .stream().map(elem -> new UserDTO(elem.getUserId(), elem.getUserName()))
                .collect(Collectors.toList());

        return new UserFollowersListDTO(user.getUserId(), user.getUserName(), followersDTO);
    }

    public UserFollowedListDTO toListUserFollowedDTO(User user, List<User> followed) {

        List<UserDTO> followedDTO = followed
                .stream().map(elem -> new UserDTO(elem.getUserId(), elem.getUserName()))
                .collect(Collectors.toList());

        return new UserFollowedListDTO(user.getUserId(), user.getUserName(), followedDTO);
    }
}
