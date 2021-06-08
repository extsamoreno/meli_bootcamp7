package com.springChallenge.api.service.implementation;

import com.springChallenge.api.controller.exception.user.AlreadyFollowedException;
import com.springChallenge.api.controller.exception.user.OwnFollowException;
import com.springChallenge.api.controller.exception.user.UserValidationsException;
import com.springChallenge.api.repository.contract.IUserRepository;
import com.springChallenge.api.repository.entity.User;
import com.springChallenge.api.service.contract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void follow(Integer userId, Integer userIdToFollow) throws UserValidationsException {
        checkNotSelfFollow(userId, userIdToFollow);

        User user = iUserRepository.getByUserId(userId);
        User userToFollow = iUserRepository.getByUserId(userIdToFollow);

        checkNotFollowed(user, userToFollow);

        user.addSellerFollowed(userToFollow);
        userToFollow.addFollower(user);

        iUserRepository.save(user);
        iUserRepository.save(userToFollow);
    }

    private void checkNotSelfFollow(Integer userId, Integer userIdToFollow) throws OwnFollowException {
        if (userId.equals(userIdToFollow))
            throw new OwnFollowException();
    }

    private void checkNotFollowed(User user, User userToFollow) throws AlreadyFollowedException {
        if (userToFollow.getFollowers().contains(user)){
            throw new AlreadyFollowedException(userToFollow.getUserId(), user.getUserId());
        }
    }
}
