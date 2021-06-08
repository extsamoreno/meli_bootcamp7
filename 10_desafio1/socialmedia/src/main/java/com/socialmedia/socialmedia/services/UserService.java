package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.UserExistAsFollowerException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.repositories.IUserRepository;
import com.socialmedia.socialmedia.repositories.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void followToUser(int userId, int userIdToFollow) throws UserNotFoundException, UserExistAsFollowerException {
        User userToFollow = userRepository.getUserById(userIdToFollow);
        User user = userRepository.getUserById(userId);

        boolean existRelation = userToFollow.getFollowers().stream()
                .anyMatch(follower -> follower.getFollowerId() == user.getId());

        if (existRelation) throw new UserExistAsFollowerException(userId, userIdToFollow);

        int idFollower = userRepository.followToUser(userId, userIdToFollow);
    }
}
