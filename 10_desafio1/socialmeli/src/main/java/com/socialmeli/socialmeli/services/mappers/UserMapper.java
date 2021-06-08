package com.socialmeli.socialmeli.services.mappers;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.services.dtos.UserFollowDTO;

public class UserMapper {
    public static UserFollowDTO getUserFollowDTO(User user){
        return new UserFollowDTO(user.getUserId(), user.getUserName());
    }
}
