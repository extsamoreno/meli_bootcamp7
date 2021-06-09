package com.meli.socialmeli.Mappers;

import com.meli.socialmeli.dto.UserFollowDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.models.UserMeli;

//@AllArgsConstructor
//@NoArgsConstructor
public class UserMapper {

    public static UserFollowDTO UserMeliToFollowDTO(UserMeli userMeli){
        return new UserFollowDTO(userMeli.getUserId(), userMeli.getUserName());
    }
    public static UserFollowerCount UserMeliToUserFollowerCount(UserMeli userMeli){
        return new UserFollowerCount(userMeli.getUserId(), userMeli.getUserName(), userMeli.getFollowers().size());
    }

    public static UserResponseDTO UserMeliToUSerResponseDTO(UserMeli userMeli){
        return new UserResponseDTO(userMeli.getUserId(), userMeli.getUserName());
    }

//    public static UserFollowerListDTO UserMeliToUserFollowerList(UserMeli userMeli){
//        return new UserFollowerListDTO(userMeli.getUserId(), userMeli.getUserName(), userMeli.getFollowers().size());
//    }
}
