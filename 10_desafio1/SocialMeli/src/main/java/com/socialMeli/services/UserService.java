package com.socialMeli.services;

import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.DTOs.FollowListDTO;
import com.socialMeli.models.DTOs.FollowersCountDTO;
import com.socialMeli.models.Seller;
import com.socialMeli.models.User;
import com.socialMeli.repository.iSocialMeliRepository;
import com.socialMeli.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserService implements iUserService {

    @Autowired
    iSocialMeliRepository repository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Void follow (Integer userId, Integer userIdToFollow) throws UserNotFoundException {
        User user = (User) repository.findById(userId);
        Seller userToFollow = (Seller) repository.findById(userIdToFollow);

        user.getFollowing().add(userToFollow);
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
        return (new FollowListDTO(userId, seller.getUsername(), seller.getFollowers()));
    }

    @Override
    public FollowListDTO listFollowed (Integer userId) throws UserNotFoundException {
        User user = (User) repository.findById(userId);
        return (new FollowListDTO(userId, user.getUsername(), mapper.mapSellerList(user.getFollowing())));
    }

    @Override
    public Void unfollow (Integer userId, Integer userIdToUnfollow) throws UserNotFoundException {
        User user = (User) repository.findById(userId);
        Seller userToUnfollow = (Seller) repository.findById(userIdToUnfollow);

        user.getFollowing().remove(userToUnfollow);
        return null;
    }

    @Override
    public Seller orderFollowersByName(Integer sellerId, String order) throws UserNotFoundException, WrongCriteriaOrderException {
        Seller seller = (Seller) repository.findById(sellerId);

        switch (order){
            case "asc":
                Collections.sort(seller.getFollowers());
                break;
            case "desc":
                Collections.sort(seller.getFollowers(), Collections.reverseOrder());
                break;
            default:
                throw new WrongCriteriaOrderException();
        }
        return seller;
    }

    @Override
    public User orderFollowedByName(Integer userId, String order) throws UserNotFoundException, WrongCriteriaOrderException {
        User user = (User) repository.findById(userId);

        switch (order){
            case "asc":
                Collections.sort(user.getFollowing());
                break;
            case "desc":
                Collections.sort(user.getFollowing(), Collections.reverseOrder());
                break;
            default:
                throw new WrongCriteriaOrderException();
        }
        return user;
    }
}
