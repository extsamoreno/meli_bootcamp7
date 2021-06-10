package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.DTO.response.*;
import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserAmountFollowersDTOres toUserAmountFollowersDTO(User user) {
        return new UserAmountFollowersDTOres(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

    public UserFollowersListDTOres toListUserFollowersDTO(User user, List<User> followers) {

        List<UserDTOres> followersDTO = followers
                .stream().map(elem -> new UserDTOres(elem.getUserId(), elem.getUserName()))
                .collect(Collectors.toList());

        return new UserFollowersListDTOres(user.getUserId(), user.getUserName(), followersDTO);
    }

    public UserFollowedListDTOres toListUserFollowedDTO(User user, List<User> followed) {

        List<UserDTOres> followedDTO = followed
                .stream().map(elem -> new UserDTOres(elem.getUserId(), elem.getUserName()))
                .collect(Collectors.toList());

        return new UserFollowedListDTOres(user.getUserId(), user.getUserName(), followedDTO);
    }

    public CountPromoProductsDTO toCountPromoProductsDTO(User user, Integer counter) {
        return new CountPromoProductsDTO(user.getUserId(), user.getUserName(), counter);
    }
}
