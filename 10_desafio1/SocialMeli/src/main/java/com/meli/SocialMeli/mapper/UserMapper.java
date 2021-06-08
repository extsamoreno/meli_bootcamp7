package com.meli.SocialMeli.mapper;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.model.User;

import java.util.ArrayList;

public class UserMapper {
    public static User userNewDtotoUser(UserNewDto userNewDto){
        return new User(-1,userNewDto.getUserName());
    }

    public static UserFollowerCountDto userToUserFollowerCDto(User user){
        return new UserFollowerCountDto(user.getUserId(),user.getUserName(),-1);
    }

    public static UserFollowerListDto userToUserFollowerLDto(User user) {
        return new UserFollowerListDto(user.getUserId(),user.getUserName(),null);
    }

    public static UserFollowedListDto userToUserFollowedLDto(User user) {
        return new UserFollowedListDto(user.getUserId(),user.getUserName(),null);
    }

    public static ArrayList<UserBasicDto> batchUserToBasicDto(ArrayList<User> users){
        ArrayList<UserBasicDto> basicUsers= new ArrayList<>();
        for(User user : users){
            basicUsers.add(userToBasicDto(user));
        }
        return basicUsers;
    }

    public static UserBasicDto userToBasicDto(User user){
        return new UserBasicDto(user.getUserId(), user.getUserName());
    }
}
