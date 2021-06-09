package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.UserExistAsFollowerException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.mappers.UserMapper;
import com.socialmedia.socialmedia.repositories.IUserRepository;
import com.socialmedia.socialmedia.repositories.entities.User;
import com.socialmedia.socialmedia.services.dtos.UserCountFollowerDTO;
import com.socialmedia.socialmedia.services.dtos.UserDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void followToUser(int userId, int userIdToFollow) throws UserNotFoundException, UserExistAsFollowerException {
        User userToFollow = userRepository.getUserById(userIdToFollow);
        User user = userRepository.getUserById(userId);

        //TODO: check si es vendedor
        boolean existRelation = userToFollow.getFollowers().stream()
                .anyMatch(follower -> follower.getFollowerId() == user.getId());

        if (existRelation) throw new UserExistAsFollowerException(userId, userIdToFollow);

        int idFollower = userRepository.followToUser(userId, userIdToFollow);
    }

    @Override
    public void unfollowToUser(int userId, int userIdToFollow) throws UserNotFoundException, UserExistAsFollowerException {
        User userToFollow = userRepository.getUserById(userIdToFollow);
        User user = userRepository.getUserById(userId);

        var followerResult = userToFollow.getFollowers().stream()
                .filter(follower -> follower.getFollowerId() == user.getId())
                .findFirst().get();

        if (Objects.isNull(followerResult)) throw new UserExistAsFollowerException(userId, userIdToFollow);

        userRepository.unfollowToUser(followerResult);
    }

    @Override
    public UserCountFollowerDTO getCountFollowersByUser(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        //TODO: check si es vendedor
        return UserMapper.UserToUserCountFollowerDTO(user);
    }

    @Override
    public UserWithFollowersDTO getFollowersByUser(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);

        List<User> followers = userRepository.getFollowersByUser(user.getId());

        List<UserDTO> followersDTO = UserMapper.UsersToUsersDTO(followers);

        return UserMapper.UserToUserWithFollowersDTO(user, followersDTO);
    }

    @Override
    public UserWithFollowedDTO getFollowedByUser(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);

        List<User> followedLst = userRepository.getFollowedByUser(user.getId());

        List<UserDTO> followedDTOs = UserMapper.UsersToUsersDTO(followedLst);

        return UserMapper.UserToUserWithFollowedDTO(user, followedDTOs);
    }
}
