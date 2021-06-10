package com.SocialMeli.services;

import com.SocialMeli.dtos.*;
import com.SocialMeli.exceptions.UserIdNotFoundException;
import com.SocialMeli.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;
    private Object FollowersCountDTO;

    @Override
    public Boolean follow(Integer userID, Integer useridtofollow) {
        return iUserRepository.follow(userID, useridtofollow);
    }

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowsException, UserCantFollowHimselfException {
        if (userId == userIdToFollow) {
            throw new UserCantFollowHimselfException(userId);
        }
    }

    @Override
    public com.SocialMeli.dtos.FollowersCountDTO getFollowersCountById(int userId) throws UserIdNotFoundException {
        return new FollowersCountDTO(userId, user.getUserName(), count);
    }

    @Override
    public FollowersListDTO getFollowersListById(int userId, String order) throws UserIdNotFoundException {
        return new FollowersListDTO(userId, user.getUserName(), userDTOArray);
    }

    @Override
    public FollowedListDTO getFollowedListById(int userId, String order) throws UserIdNotFoundException {
        return new FollowedListDTO(userId,user.getUserName(),userDTOArray);
    }
}