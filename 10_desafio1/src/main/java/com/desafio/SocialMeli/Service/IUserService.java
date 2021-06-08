package com.desafio.SocialMeli.Service;

import com.desafio.SocialMeli.DTO.*;
import com.desafio.SocialMeli.Exception.Post.PostExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductIdNotFoundException;
import com.desafio.SocialMeli.Exception.User.UserExistsException;
import com.desafio.SocialMeli.Exception.User.UserFollowedByHimselfException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;

public interface IUserService {

    UserDTO createUser(String userName) throws UserExistsException;

    void followUser(int userId, int userIdToFollow) throws UserIdNotFoundException, UserFollowedByHimselfException;

    FollowersCountDTO getFollowersCount(int userId) throws UserIdNotFoundException;

    FollowersListDTO getFollowersList (int userId) throws UserIdNotFoundException;

    FollowedListDTO getFollowedList (int userId) throws UserIdNotFoundException;

}
