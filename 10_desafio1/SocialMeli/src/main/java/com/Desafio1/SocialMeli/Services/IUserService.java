package com.Desafio1.SocialMeli.Services;

import com.Desafio1.SocialMeli.DTOS.*;
import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.NotSellerException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Models.Post;
import com.Desafio1.SocialMeli.Models.User;

import java.util.List;

public interface IUserService {
    List<User> newUser(CreateUserDTO createUserDTO) throws DuplicateIdException;
    void followSeller(int userId, int userIdToFollow) throws UserNotFoundException, DuplicateIdException, NotSellerException;
    List<User> getUsers();
    void updateUser(User seller);
    FollowerCountDTO getFollowersCount(int userID) throws UserNotFoundException;
    FollowerListDTO getFollowersByUserId(int userID, String sortBy) throws UserNotFoundException;
    FollowedListDTO getFollowedByUserId(int userID, String sortBy) throws UserNotFoundException;
    User searchUserById(int userId) throws UserNotFoundException;
    List<Post> getFollowedPostList(List<UserDTO> followed) throws UserNotFoundException;
    void unFollowSeller(int userId, int userIdToUnFollow) throws UserNotFoundException;


}
