package com.springChallenge.api.service.implementation;

import com.springChallenge.api.controller.dto.user.FollowedListDTO;
import com.springChallenge.api.controller.dto.user.FollowerCountDTO;
import com.springChallenge.api.controller.dto.user.FollowerListDTO;
import com.springChallenge.api.controller.exception.user.*;
import com.springChallenge.api.repository.contract.IUserRepository;
import com.springChallenge.api.repository.entity.User;
import com.springChallenge.api.service.contract.IUserService;
import com.springChallenge.api.service.mapper.user.FollowedListMapper;
import com.springChallenge.api.service.mapper.user.FollowerCountMapper;
import com.springChallenge.api.service.mapper.user.FollowerListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    /**
     * add a sellerFollowed to an user, adding himself to the list of followers of the latter user
     * @param userId
     * @param userIdToFollow
     * @throws UserValidationsException
     */
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

    /**
     * gets the total of followers of a given user by his id
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public FollowerCountDTO getFollowerCount(Integer userId) throws UserNotFoundException {
        User user = iUserRepository.getByUserId(userId);
        return FollowerCountMapper.mapToDTO(user);
    }

    /**
     * gets the list of followers of a given user by his id
     * @param userId
     * @param order
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public FollowerListDTO getFollowerList(Integer userId, String order) throws UserNotFoundException {
        User user = iUserRepository.getByUserId(userId);
        if (!order.isEmpty())
            orderUserList(user.getFollowers(), order);
        return FollowerListMapper.mapToDTO(user);
    }

    /**
     * order the user list by userName
     * @param list
     * @param order
     */
    private void orderUserList(ArrayList<User> list, String order) {
        if (order.equals("name_asc")) {
            Collections.sort(list);
        } else {
            list.sort(Collections.reverseOrder());
        }
    }

    /**
     * gets the list of followed users by an user given his id
     * @param userId
     * @param order
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public FollowedListDTO getFollowedList(Integer userId, String order) throws UserNotFoundException {
        User user = iUserRepository.getByUserId(userId);
        if (!order.isEmpty())
            orderUserList(user.getSellersFollowed(), order);
        return FollowedListMapper.mapToDTO(user);
    }

    /**
     * remove a sellerFollowed to an user, removing himself from the followers list of the latter
     * @param userId
     * @param userIdToUnfollow
     * @throws UserValidationsException
     */
    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) throws UserValidationsException {
        checkNotSelfFollow(userId, userIdToUnfollow);

        User user = iUserRepository.getByUserId(userId);
        User userToUnfollow = iUserRepository.getByUserId(userIdToUnfollow);

        checkFollowed(user, userToUnfollow);

        user.removeSellerFollowed(userToUnfollow);
        userToUnfollow.removeFollower(user);

        iUserRepository.save(user);
        iUserRepository.save(userToUnfollow);
    }

    /**
     * checks if the user is not following the other user
     * @param user
     * @param userToUnfollow
     * @throws NotFollowedException
     */
    private void checkFollowed(User user, User userToUnfollow) throws NotFollowedException {
        if (!userToUnfollow.getFollowers().contains(user))
            throw new NotFollowedException(userToUnfollow.getUserId(), user.getUserId());
    }

    /**
     * checks if the two params are the same
     * @param userId
     * @param userIdToFollow
     * @throws OwnFollowException
     */
    private void checkNotSelfFollow(Integer userId, Integer userIdToFollow) throws OwnFollowException {
        if (userId.equals(userIdToFollow))
            throw new OwnFollowException();
    }

    /**
     * checks if the user is already following the other user
     * @param user
     * @param userToFollow
     * @throws AlreadyFollowedException
     */
    private void checkNotFollowed(User user, User userToFollow) throws AlreadyFollowedException {
        if (userToFollow.getFollowers().contains(user)){
            throw new AlreadyFollowedException(userToFollow.getUserId(), user.getUserId());
        }
    }
}
