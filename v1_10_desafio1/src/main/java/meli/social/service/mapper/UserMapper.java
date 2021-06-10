package meli.social.service.mapper;

import meli.social.model.UserModel;
import meli.social.service.dto.UserDTO;
import meli.social.service.dto.UserFollowedListDTO;
import meli.social.service.dto.UserFollowersCounterDTO;
import meli.social.service.dto.UserFollowersListDTO;

import java.util.List;

public class UserMapper {
    public static UserFollowersCounterDTO toFollowersCounterDto(UserModel user) {
        return new UserFollowersCounterDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }
    public static UserFollowersListDTO toFollowersListDto (UserModel user, List<UserDTO> followers) {
        return new UserFollowersListDTO(user.getUserId(), user.getUserName(), followers);
    }

    public static UserFollowedListDTO toFollowedListDto (UserModel user, List<UserDTO> followed) {
        return new UserFollowedListDTO(user.getUserId(), user.getUserName(), followed);
    }
}
