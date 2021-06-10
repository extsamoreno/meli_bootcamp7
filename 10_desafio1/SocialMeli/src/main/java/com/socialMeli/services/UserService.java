package com.socialMeli.services;

import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.mapper.iSocialMeliMapper;
import com.socialMeli.models.DTOs.FollowListDTO;
import com.socialMeli.models.DTOs.FollowersCountDTO;
import com.socialMeli.models.DTOs.UserDTO;
import com.socialMeli.models.Seller;
import com.socialMeli.models.User;
import com.socialMeli.repository.iSocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class UserService implements iUserService {

    @Autowired
    iSocialMeliRepository repository;
    @Autowired
    iSocialMeliMapper mapper;

    @Override
    public Void follow (Integer userId, Integer userIdToFollow) throws UserNotFoundException {
        User user = repository.findUserById(userId);
        Seller userToFollow = repository.findSellerById(userIdToFollow);

        user.getFollowing().add(userToFollow);
        return null;
    }

    @Override
    public FollowersCountDTO countFollowers (Integer userId) throws UserNotFoundException {
        Seller seller = repository.findSellerById(userId);
        return (new FollowersCountDTO(userId, seller.getUsername(), seller.getFollowers().size()));
    }

    @Override
    public FollowListDTO listFollowers (Integer userId) throws UserNotFoundException {
        Seller seller = repository.findSellerById(userId);
        return (new FollowListDTO(userId, seller.getUsername(), seller.getFollowers()));
    }

    @Override
    public FollowListDTO listFollowed (Integer userId) throws UserNotFoundException {
        User user = repository.findUserById(userId);
        return (new FollowListDTO(userId, user.getUsername(), mapper.mapSellerToUserDTOList(user.getFollowing())));
    }

    @Override
    public Void unfollow (Integer userId, Integer userIdToUnfollow) throws UserNotFoundException {
        User user = repository.findUserById(userId);
        Seller userToUnfollow = repository.findSellerById(userIdToUnfollow);

        user.getFollowing().remove(userToUnfollow);
        return null;
    }

    @Override
    public ArrayList<UserDTO> orderFollowersByName(Integer sellerId, String order) throws UserNotFoundException, WrongCriteriaOrderException {
        Seller seller = repository.findSellerById(sellerId);

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
        return seller.getFollowers();
    }

    @Override
    public ArrayList<Seller> orderFollowedByName(Integer userId, String order) throws UserNotFoundException, WrongCriteriaOrderException {
        User user = repository.findUserById(userId);

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
        return user.getFollowing();
    }
}
