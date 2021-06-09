package com.meli.socialmeli.services;

import com.meli.socialmeli.Mappers.UserMapper;
import com.meli.socialmeli.dto.UserFollowDTO;
import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.UserInvalidException;
import com.meli.socialmeli.exceptions.UserNotFoundException;
import com.meli.socialmeli.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserFollowDTO follow(int userId, int userIdToFollow) throws UserInvalidException {
        if (userId != userIdToFollow) {
            return UserMapper.UserMeliToFollowDTO( iUserRepository.followMerchant(userId, userIdToFollow) );
        } else {
            throw new UserInvalidException();
        }
        //return UserMapper.UserMeliToFollowDTO( iUserRepository.followMerchant(userId, userIdToFollow) );
    }

    @Override
    public UserFollowerCount getFollowerCount(int userId) {
        return UserMapper.UserMeliToUserFollowerCount( iUserRepository.getFollowerCountById(userId));
    }

    @Override
    public UserFollowerListDTO getFollowerList(int userId) {
        return iUserRepository.getListFollowersById(userId);
    }

    @Override
    public UserFollowedByListDTO getFollowedBy(int userId) {
        return iUserRepository.getListFollowedById(userId);
    }

    @Override
    public UserFollowDTO unfollow(int userId, int userIdTounfollow) throws UserInvalidException, UserNotFoundException {
        if (userId != userIdTounfollow) {
            return UserMapper.UserMeliToFollowDTO( iUserRepository.unfollowMerchant(userId, userIdTounfollow) );
        } else {
            throw new UserInvalidException();
        }
    }

//    @Override
//    public FollowDTO getFollowerById(int userId) {
//        return iUserRepository.;
//    }
//
//    @Override
//    public ArrayList<FollowDTO> getFollowersById(int userId) {
//        return null;
//    }


}
