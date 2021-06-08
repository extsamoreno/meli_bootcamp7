package com.reto1.demo.Model.DTO.Mapper;
import com.reto1.demo.Model.DTO.UserDTO;
import com.reto1.demo.Model.DTO.UserDTOCount;
import com.reto1.demo.Model.DTO.UserDTOFolloweds;
import com.reto1.demo.Model.DTO.UserDTOFollowers;
import com.reto1.demo.Model.User;
import java.util.ArrayList;

public class UserMapper {

    public static UserDTOCount toUserDTO(User user){
        return new UserDTOCount(user.getId(), user.getName(), user.getFollowers().size());
    }

    public static UserDTOFollowers toUserFollowers(User user) {
        ArrayList<UserDTO> followersDTO = new ArrayList<>();
        user.getFollowers().forEach(follower-> followersDTO.add(toUser((User)follower)));
        return new UserDTOFollowers(user.getId(), user.getName(),followersDTO);
    }

    public static UserDTO toUser(User user){
        return new UserDTO(user.getId(), user.getName());
    }

    public static UserDTOFolloweds toUserFolloweds(User user) {
        ArrayList<UserDTO> followedsDTO = new ArrayList<>();
        user.getFollowed().forEach(follower-> followedsDTO.add(toUser((User)follower)));
        return new UserDTOFolloweds(user.getId(), user.getName(),followedsDTO);
    }
}
