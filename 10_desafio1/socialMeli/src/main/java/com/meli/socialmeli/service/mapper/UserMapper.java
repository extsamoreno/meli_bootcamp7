package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.user.UserDTO;
import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersDTO;

import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {
    /**
     * converts from user to UserWithFollowersCountDTO
     *
     * @param user
     * @return
     */
    public static UserWithFollowersCountDTO toFollowersCountDTO(User user) {
        Integer count = user.getFollowers().size();
        return new UserWithFollowersCountDTO(user.getUserId(), user.getUserName(), count);
    }

    /**
     * converts from user to UserWithFollowersDTO
     *
     * @param user
     * @return
     */
    public static UserWithFollowersDTO toFollowersDTO(User user) {
        return new UserWithFollowersDTO(user.getUserId(), user.getUserName(), toUserDTOList(user.getFollowers()));
    }

    /**
     * converts from user to UserWithFollowedDTO
     *
     * @param user
     * @return
     */
    public static UserWithFollowedDTO toFollowedDTO(User user) {
        return new UserWithFollowedDTO(user.getUserId(), user.getUserName(), toUserDTOList(user.getFollowed()));
    }

    /**
     * converts a list of user to a list of UserDTO
     *
     * @param list
     * @return
     */
    public static List<UserDTO> toUserDTOList(List<User> list) {
        return list.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }

    /**
     * converts from user to UserDTO
     *
     * @param user
     * @return
     */
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }


}
