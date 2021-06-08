package com.socialMeli.user;

import com.socialMeli.user.exceptions.UserNotFoundException;
import com.socialMeli.user.models.*;
import com.socialMeli.user.repository.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements iUserService {

    @Autowired
    iUserRepository repository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Void follow (Integer userId, Integer userIdToFollow) throws UserNotFoundException {
        User user = (User) repository.findById(userId);
        Seller userToFollow = (Seller) repository.findById(userIdToFollow);

        user.getFollowing().add(userToFollow);
        userToFollow.getFollowers().add(user);
        return null;
    }

    @Override
    public FollowersCountDTO countFollowers (Integer userId) throws UserNotFoundException {
        Seller seller = (Seller) repository.findById(userId);
        return (new FollowersCountDTO(userId, seller.getUsername(), seller.getFollowers().size()));
    }

    @Override
    public FollowListDTO listFollowers (Integer userId) throws UserNotFoundException {
        Seller seller = (Seller) repository.findById(userId);
        return (new FollowListDTO(userId, seller.getUsername(), mapper.mapUserList(seller.getFollowers())));
    }

    @Override
    public FollowListDTO listFollowed (Integer userId) throws UserNotFoundException {
        User user = (User) repository.findById(userId);
        return (new FollowListDTO(userId, user.getUsername(), mapper.mapSellerList(user.getFollowing())));
    }
}
