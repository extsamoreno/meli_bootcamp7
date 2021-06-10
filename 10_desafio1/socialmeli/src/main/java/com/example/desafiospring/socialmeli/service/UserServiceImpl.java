package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.PostIdAlreadyExistException;
import com.example.desafiospring.socialmeli.exception.UserException;
import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Seller;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.repository.IUserRepository;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.service.DTO.UserFollowDTO;
import com.example.desafiospring.socialmeli.service.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository repository;
    @Autowired
    IUserMapper mapper;

    /**
     * 0001 - Follows certain seller
     */
    @Override
    public Void follow (Integer userId, Integer userIdToFollow) throws UserNotFoundException, PostIdAlreadyExistException {
        User user = repository.findBy(userId);
        Seller userToFollow = repository.findBy(getUserFollowed());

        if (!user.getFollowing().stream().filter(seller -> seller.getUsername().equals(userToFollow.getUsername())).collect(Collectors.toList()).isEmpty())
            throw new PostIdAlreadyExistException(user.getUsername());

        user.getFollowing().add(userToFollow);
        return null;
    }

    /**
     *0002 - Gets the amount of users that follows a certain seller
     */
    @Override
    public UserFollowDTO countFollowers (Integer userId) throws UserNotFoundException {
        Seller seller = repository.findBy(userId);
        return (new UserFollowDTO(userId, seller.getUsername(), seller.getFollowers().size()));
    }

    /**
     * 0003 - Gets a list of the users that follow a certain seller
     */
    @Override
    public UserFollowDTO listFollowers (Integer userId) throws UserNotFoundException {
        Seller seller = repository.findBy(userId);
        return (new UserFollowDTO(userId, seller.getUsername(), seller.getFollowers()));
    }

    /**
     * 0004 - Gets a list of the sellers followed by a certain user
     */
    @Override
    public UserFollowDTO listFollowed (Integer userId) throws UserNotFoundException {
        User user = repository.findBy(userId);
        return (new UserFollowDTO(userId, user.getUsername(), mapper.mapSellerToUserDTOList(user.getFollowing())));
    }

    /**
     *005

     */
    @Override
    public Void unfollow (Integer userId, Integer userIdToUnfollow) throws UserNotFoundException, UserNotFoundException {
        User user = repository.findBy(userId);
        Seller userToUnfollow = repository.findBy(userIdToUnfollow);

        if (user.getFollowing().stream().filter(seller -> seller.getUsername().equals(userToUnfollow.getUsername())).collect(Collectors.toList()).isEmpty())
            throw new UserNotFoundException(user.getUsername());
        user.getFollowing().remove(userToUnfollow);

        return null;
    }

    /**
     * 0008 - Orders followers by name (asc or desc)
     */
    @Override
    public ArrayList<UserDTO> orderFollowersByName(Integer sellerId, String order) throws UserNotFoundException, UserException {
        Seller seller = repository.findBy(sellerId);

        switch (order){
            case "name_asc":
                Collections.sort(seller.getFollowers());
                break;
            case "name_desc":
                Collections.sort(seller.getFollowers(), Collections.reverseOrder());
                break;
            default:
                throw new UserException();
        }
        return seller.getFollowers();
    }

    /**
     * 0008 - Orders followed by name (asc or desc)
     */
    @Override
    public ArrayList<Seller> orderFollowedByName(Integer userId, String order) throws UserNotFoundException, UserException {
        User user = repository.findBy(userId);

        switch (order){
            case "name_asc":
                Collections.sort(user.getFollowing());
                break;
            case "name_desc":
                Collections.sort(user.getFollowing(), Collections.reverseOrder());
                break;
            default:
                throw new UserException();
        }
        return user.getFollowing();
    }
}