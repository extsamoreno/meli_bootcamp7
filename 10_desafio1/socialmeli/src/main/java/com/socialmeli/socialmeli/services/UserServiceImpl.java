package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.UserRepository;
import com.socialmeli.socialmeli.services.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException {
        userRepository.getUserById(userId);
        userRepository.getUserById(userIdToFollow);
        userRepository.addFollowerToUser(userId,userIdToFollow);
    }

    @Override
    public UserDTO getUserFollowersCount(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        int followersCount = userRepository.getFollowersCount(userId);
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                followersCount
        );
    }

}
