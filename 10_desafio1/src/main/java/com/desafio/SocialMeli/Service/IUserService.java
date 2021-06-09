package com.desafio.SocialMeli.Service;

import com.desafio.SocialMeli.DTO.User.FollowedListDTO;
import com.desafio.SocialMeli.DTO.User.FollowersCountDTO;
import com.desafio.SocialMeli.DTO.User.FollowersListDTO;
import com.desafio.SocialMeli.DTO.User.UserDTO;
import com.desafio.SocialMeli.Exception.User.OrderNotFoundException;
import com.desafio.SocialMeli.Exception.User.UserExistsException;
import com.desafio.SocialMeli.Exception.User.UserFollowedByHimselfException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;

public interface IUserService {

    UserDTO createUser(String userName) throws UserExistsException;

    void followUser(int userId, int userIdToFollow) throws UserIdNotFoundException, UserFollowedByHimselfException;

    FollowersCountDTO getFollowersCount(int userId) throws UserIdNotFoundException;

    FollowersListDTO getFollowersList(int userId, String order) throws UserIdNotFoundException, OrderNotFoundException;

    FollowedListDTO getFollowedList(int userId, String order) throws UserIdNotFoundException, OrderNotFoundException;

    void unFollowUser(int userId, int userIdToFollow) throws UserIdNotFoundException, UserFollowedByHimselfException;
}
