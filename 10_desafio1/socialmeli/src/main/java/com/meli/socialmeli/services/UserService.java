package com.meli.socialmeli.services;

import com.meli.socialmeli.Mappers.UserMapper;
import com.meli.socialmeli.dto.UserFollowDTO;
import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.*;
import com.meli.socialmeli.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserFollowDTO follow(int userId, int userIdToFollow) throws UserInvalidException, UserItselfException, UserIsNotMerchant, UserDoNotExistsException {
        if (userId != userIdToFollow) {
            return UserMapper.UserMeliToFollowDTO(iUserRepository.followMerchant(userId, userIdToFollow));
        } else {
            throw new UserItselfException();
        }
    }

    @Override
    public UserFollowerCount getFollowerCount(int userId) {
        return UserMapper.UserMeliToUserFollowerCount(iUserRepository.getFollowerCountById(userId));
    }

    @Override
    public UserFollowerListDTO getFollowerList(int userId, String order) {
        return iUserRepository.getListFollowersById(userId, order);
    }

    @Override
    public UserFollowedByListDTO getFollowedBy(int userId, String order) {
        return iUserRepository.getListFollowedById(userId, order);
    }

    @Override
    public UserFollowDTO unfollow(int userId, int userIdTounfollow) throws UserInvalidException, UserNotFoundException {
        if (userId != userIdTounfollow) {
            return UserMapper.UserMeliToFollowDTO(iUserRepository.unfollowMerchant(userId, userIdTounfollow));
        } else {
            throw new UserInvalidException();
        }
    }
}
