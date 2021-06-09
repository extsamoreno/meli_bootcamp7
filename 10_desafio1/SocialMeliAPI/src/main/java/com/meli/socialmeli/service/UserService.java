package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserAlreadyUnfollowedException;
import com.meli.socialmeli.exception.UserNotFoundException;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.UserDTOFollowedList;
import com.meli.socialmeli.service.dto.UserDTOFollowersCount;
import com.meli.socialmeli.service.dto.UserDTOFollowersList;
import com.meli.socialmeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public HttpStatus followUser(int userId, int userIdToFollow) throws UserAlreadyFollowedException, UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId);
        User userToFollow= iUserRepository.getUserById(userIdToFollow);
        if (actualUser==null) throw new UserNotFoundException(userId);
        if (userToFollow==null) throw new UserNotFoundException(userIdToFollow);
        if (actualUser.getFollowed().contains(userToFollow)){
            throw new UserAlreadyFollowedException(userToFollow);
        } else {
            actualUser.addFollowed(userToFollow);
            userToFollow.addFollower(actualUser);
            return HttpStatus.OK;
        }
    }

    @Override
    public UserDTOFollowersCount getFollowersCount(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId);
        if (actualUser==null){
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowerCount(actualUser);
    }

    @Override
    public UserDTOFollowersList getFollowersList(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId);
        if(actualUser==null){
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowerList(actualUser);
    }

    @Override
    public UserDTOFollowedList getFollowedList(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId);
        if(actualUser==null){
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowedList(actualUser);
    }

    @Override
    public HttpStatus unfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException, UserAlreadyUnfollowedException {
        User actualUser=iUserRepository.getUserById(userId);
        User userToUnfollow= iUserRepository.getUserById(userIdToUnfollow);
        if (actualUser==null) throw new UserNotFoundException(userId);
        if (userToUnfollow==null) throw new UserNotFoundException(userIdToUnfollow);
        if (!actualUser.getFollowed().contains(userToUnfollow)){
            throw new UserAlreadyUnfollowedException(userToUnfollow);
        } else {
            actualUser.getFollowed().remove(userToUnfollow);
            userToUnfollow.getFollowers().remove(actualUser);
            return HttpStatus.OK;
        }
    }
}
