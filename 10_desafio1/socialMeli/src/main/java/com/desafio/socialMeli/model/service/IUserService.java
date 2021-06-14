package com.desafio.socialMeli.model.service;


import com.desafio.socialMeli.model.exceptions.RemoveFollowedException;
import com.desafio.socialMeli.model.exceptions.RemoveFollowerException;
import com.desafio.socialMeli.model.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.model.exceptions.UserNotFoundException;
import com.desafio.socialMeli.model.dto.UserFollowedDTO;
import com.desafio.socialMeli.model.dto.UserFollowersCountDTO;
import com.desafio.socialMeli.model.dto.UserFollowersDTO;


public interface IUserService {

    String followById(Integer userId, Integer userIdToFollow) throws UserNotFoundException, RepositoryUnableException;
    String unfollowById(Integer userId, Integer userIdToFollow) throws UserNotFoundException, RepositoryUnableException, RemoveFollowerException, RemoveFollowedException;
    String loadDatabaseDTO();
    UserFollowersCountDTO followersCount(Integer userId) throws RepositoryUnableException, UserNotFoundException;
    UserFollowersDTO followersList(Integer userId) throws RepositoryUnableException, UserNotFoundException;
    UserFollowedDTO followedList(Integer userId) throws RepositoryUnableException, UserNotFoundException;
    UserFollowedDTO followedList(Integer userId, String order) throws RepositoryUnableException, UserNotFoundException;
    UserFollowersDTO followersList(Integer userId, String order) throws RepositoryUnableException, UserNotFoundException;


}

