package com.meli.socialmeli.service.user;

import com.meli.socialmeli.dto.user.FollowersCountDTO;
import com.meli.socialmeli.dto.user.UserFollowedDTO;
import com.meli.socialmeli.dto.user.UserFollowersDTO;
import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import com.meli.socialmeli.exception.UserNotFollowedException;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.user.IUserRepository;
import com.meli.socialmeli.service.mapper.UserMapper;
import com.meli.socialmeli.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowedException {
        User userFrom = iUserRepository.findUserById(userId);
        User userTo = iUserRepository.findUserById(userIdToFollow);

        if(userFrom == null) {
            throw new UserIdNotFoundException(userId);
        }

        if(userTo == null) {
            throw new UserIdNotFoundException(userIdToFollow);
        }

        if(!iUserRepository.addFollower(userTo,userFrom))
            throw new UserAlreadyFollowedException(userId,userIdToFollow);
    }

    @Override
    public FollowersCountDTO getFollowersCount(Integer userId) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        return new FollowersCountDTO(user.getUserId(), user.getUserName(), iUserRepository.getUserFollowers(userId,null).size());
    }

    @Override
    public UserFollowersDTO getUserFollowers(Integer userId, String order) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        return new UserFollowersDTO(user.getUserId(), user.getUserName(), UserMapper.toUsersDTO(iUserRepository.getUserFollowers(userId,order)));
    }

    @Override
    public UserFollowedDTO getUserFollowed(Integer userId, String order) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        return new UserFollowedDTO(user.getUserId(), user.getUserName(), UserMapper.toUsersDTO(iUserRepository.getUserFollowed(userId,order)));
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) throws UserIdNotFoundException, UserNotFollowedException {
        if(iUserRepository.findUserById(userId) == null) {
            throw new UserIdNotFoundException(userId);
        }

        if(iUserRepository.findUserById(userIdToUnfollow) == null) {
            throw new UserIdNotFoundException(userIdToUnfollow);
        }

        if(!iUserRepository.deleteFollower(userId,userIdToUnfollow))
            throw new UserNotFollowedException(userId,userIdToUnfollow);
    }
}