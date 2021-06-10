package com.SocialMeli.services;

import com.SocialMeli.dtos.*;
import com.SocialMeli.exceptions.UserAlreadyFollowsException;
import com.SocialMeli.exceptions.UserException;
import com.SocialMeli.exceptions.UserIdNotFoundException;
import com.SocialMeli.exceptions.UsersCantFollowThemselvesException;
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
    public FollowersCountDTO getFollowersCountById(Integer Integer) throws UserIdNotFoundException, UserIdNotFoundException {
        return null;
    }

    public void FollowUserDTO(Integer userId, Integer userIdToFollow) throws UserException, UserIdNotFoundException, UserAlreadyFollowsException, UsersCantFollowThemselvesException, UserIdNotFoundException, UserAlreadyFollowsException {

    }

    @Override
    public FollowersListDTO getFollowersListById(Integer userId, String order) throws UserIdNotFoundException, UserIdNotFoundException {
        return null;
    }

    @Override
    public FollowedListDTO getFollowedListById(Integer userId, String order) throws UserIdNotFoundException, UserIdNotFoundException {
        return null;
    }

    @Override
    public FollowersListDTO getFollowing(Integer id) {
        return null;
    }


}