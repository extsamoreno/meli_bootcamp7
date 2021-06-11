package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.exception.UsersMustBeDifferentException;
import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.service.dto.FollowedUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserFollowersCountDTOResponse;

import java.util.Optional;

public interface IUserService {
    boolean follow(Integer idUser, Integer idUserToFollow) throws UserNotFoundException, UsersMustBeDifferentException;
    boolean unfollow(Integer idUser, Integer idUserToUnfollow) throws UserNotFoundException, UsersMustBeDifferentException;
    UserFollowersCountDTOResponse getFollowersCount(Integer idUser) throws UserNotFoundException;
    FollowersUserDTOResponse getFollowersList(Integer idUser, Optional<String> order) throws UserNotFoundException;
    FollowersUserDTOResponse getFollowedList(Integer idUser, Optional<String> order) throws UserNotFoundException;
    User getUser(Integer id) throws UserNotFoundException;
}