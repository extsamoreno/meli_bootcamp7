package com.SocialMeli.services;

import com.SocialMeli.dtos.FollowUserDTO;
import com.SocialMeli.dtos.FollowedUserDTO;
import com.SocialMeli.dtos.FollowerUserDTO;
import com.SocialMeli.dtos.FollowersCountDTO;
import com.SocialMeli.exceptions.UserException;
import com.SocialMeli.exceptions.UserIdNotFoundException;
import com.SocialMeli.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;
    private Object FollowersCountDTO;

    @Override
    public Object followUserDTO(int userId, int followedId) {
        return null;
    }

    @Override
    public FollowedUserDTO addFollowUser(int userId, int userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed, UserNotFoundException {
        return null;
    }

    @Override
    public FollowerCountDTO findFollowersCount(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        return null;
    }

    @Override
    public FollowerUserDTO findFollowersByUserId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        return null;
    }

    @Override
    public FollowUserDTO findFollowedByUserId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        return null;
    }

    @Override
    public FollowedUserDTO unfollowUser(int userId, int userIdToUnfollow) throws UserIdFollowerEqualsFollowed, UserIdInvalidException, UserNotFoundException, UnhandledException {
        return null;
    }

    @Override
    public Boolean follow(Integer userID, Integer useridtofollow) {
        return iUserRepository.follow(userID, useridtofollow);
    }

    @Override
    public String followUser(int userId, int userIdToFollow) throws UserException {
        return null;
    }

    @Override
    public String FollowersCountDTO(int userId) throws UserNotFoundException {
        return null;
    }

    @Override
    public Object getFollowerCount(Integer id) {
        return iUserRepository.findFollowedByUserId(userID, findFollowersByUserId();
    }

    @Override
    private Object findFollowersByUserId() {
    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        return FollowersCountDTO;
    }

    @Override
    public ResponseEntity<FollowedUserDTO> followerCount(Integer id) throws UserIdNotFoundException {
        return null;
    }
}
