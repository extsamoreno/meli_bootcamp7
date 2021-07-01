package com.socialmeli.socialmeli.services.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
    int userId;
    String userName;
    List<UserFollowDTO> followers;
    List<UserFollowDTO> followed;

    public UserDTO(int userId,String userName,int followers_count){
        this.userId = userId;
        this.userName = userName;
    }

    public UserDTO(int userId,String userName,List<UserFollowDTO> followers){
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public UserDTO(String userName,int userId,  List<UserFollowDTO> followed){
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }

}