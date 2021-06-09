package com.meli.socialmeli.services;

import com.meli.socialmeli.Mappers.UserMapper;
import com.meli.socialmeli.dto.FollowDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.UserInvalidException;
import com.meli.socialmeli.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public FollowDTO follow(int userId, int userIdToFollow) throws UserInvalidException {
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
        return iUserRepository.getListFolloweraById(userId);
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
