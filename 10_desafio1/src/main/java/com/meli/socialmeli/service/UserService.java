package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.FollowersCountUserDTO;
import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.exception.FollowerAlreadyAddedException;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.NoFollowerException;
import com.meli.socialmeli.models.User;
import com.meli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.meli.socialmeli.mapper.UserMapper.mapFollowed;
import static com.meli.socialmeli.mapper.UserMapper.mapFollowers;
import static com.meli.socialmeli.util.UserUtil.sortFollows;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Inserts a new follower. This performs two actions:
     * 1) In the user who will be a follower, a new followed user is inserted
     * 2) In the user that is followed, a new follower is inserted
     *
     * @param userId         Corresponding to the user who will follow another
     * @param userIdToFollow Corresponding to the user to be followed
     * @throws InvalidIdException            If either or both of the IDs entered do not correspond to an existing user
     * @throws FollowerAlreadyAddedException If the user to be added as a follower is already a follower of the followed user
     */
    public void addFollower(int userId, int userIdToFollow) throws InvalidIdException, FollowerAlreadyAddedException {

        if (userRepository.userIdIsNotValid(userId) || userRepository.userIdIsNotValid(userIdToFollow)) {
            throw new InvalidIdException();
        }

        if (userRepository.userContainsFollower(userId, userIdToFollow)) {
            throw new FollowerAlreadyAddedException();
        }
        userRepository.insertFollower(userId, userIdToFollow);
    }

    /**
     * Removes a follower.This performs two actions:
     * 1) In the user who will unfollow, the followed user is deleted
     * 2) In the user that will stop being followed, the follower is deleted
     *
     * @param userId           Corresponding to the user who will unfollow another
     * @param userIdToUnfollow Corresponding with the user who will be unfollowed
     * @throws InvalidIdException  If either or both of the IDs entered do not correspond to an existing user
     * @throws NoFollowerException If the user to be removed from the followers, is not a seller´s follower
     */
    public void removeFollower(int userId, int userIdToUnfollow) throws InvalidIdException, NoFollowerException {

        if (userRepository.userIdIsNotValid(userId) || userRepository.userIdIsNotValid(userIdToUnfollow)) {
            throw new InvalidIdException();
        }

        if (!userRepository.userContainsFollower(userId, userIdToUnfollow)) {
            throw new NoFollowerException();
        }
        userRepository.removeFollower(userId, userIdToUnfollow);
    }

    /**
     * Gets the number of followers a user has
     *
     * @param userId Corresponding to the user from which you want to obtain the followers count
     * @return The number of followers a user has
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    public FollowersCountUserDTO getFollowersCount(int userId) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        int followersCount = userRepository.getNumberOfFollowers(userId);

        FollowersCountUserDTO followersCountUserDTO = new FollowersCountUserDTO();

        followersCountUserDTO.setUserId(userId);
        followersCountUserDTO.setFollowersCount(followersCount);
        followersCountUserDTO.setUserName(userRepository.getUserById(userId).getUserName());

        return followersCountUserDTO;
    }

    /**
     * Get the followers that a user has.
     *
     * @param userId Corresponding to the user from which you want to obtain the followers
     * @param order  The alphabetical order in which you want to obtain the results. This order can be ascending or descending
     * @return The user who has been searched, with the followers that this user has
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    public UserDTO getFollowersList(int userId, String order) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        User user = userRepository.getUserById(userId);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserName(user.getUserName());

        userDTO.setFollowers(sortFollows(mapFollowers(user), order));

        return userDTO;
    }

    /**
     * Gets the sellers that the entered user follows
     *
     * @param userId Corresponding to the user from whom you want to obtain the followed sellers
     * @param order  The alphabetical order in which you want to obtain the results. This order can be ascending or descending
     * @return The user who has been searched, with the sellers that the user follows
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    public UserDTO getFollowedList(int userId, String order) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        User user = userRepository.getUserById(userId);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserName(user.getUserName());

        userDTO.setFollowed(sortFollows(mapFollowed(user), order));

        return userDTO;
    }
}
