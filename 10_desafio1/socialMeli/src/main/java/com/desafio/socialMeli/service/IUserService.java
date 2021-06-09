package com.desafio.socialMeli.service;


import com.desafio.socialMeli.exceptions.RemoveFollowedException;
import com.desafio.socialMeli.exceptions.RemoveFollowerException;
import com.desafio.socialMeli.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.exceptions.UserNotFoundException;
import com.desafio.socialMeli.service.dto.UserFollowedDTO;
import com.desafio.socialMeli.service.dto.UserFollowersCountDTO;
import com.desafio.socialMeli.service.dto.UserFollowersDTO;


public interface IUserService {

    String followById(Integer userId, Integer userIdToFollow) throws UserNotFoundException, RepositoryUnableException;
    String unfollowById(Integer userId, Integer userIdToFollow) throws UserNotFoundException, RepositoryUnableException, RemoveFollowerException, RemoveFollowedException;
    String loadDatabaseDTO();
    UserFollowersCountDTO followersCount(Integer userId) throws RepositoryUnableException, UserNotFoundException;
    UserFollowersDTO followersList(Integer userId) throws RepositoryUnableException, UserNotFoundException;
    UserFollowedDTO followedList(Integer userId) throws RepositoryUnableException, UserNotFoundException;

}

