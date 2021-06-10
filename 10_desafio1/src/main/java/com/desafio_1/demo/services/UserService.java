package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.UserFollowedDTO;
import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.exceptions.UserIdFollowerEqualsFollowed;
import com.desafio_1.demo.exceptions.UserIdInvalidException;
import com.desafio_1.demo.exceptions.UserNotFoundException;
import com.desafio_1.demo.models.User;
import com.desafio_1.demo.repositories.IUserRepository;
import com.desafio_1.demo.services.mappers.UserFollowerCountMapper;
import com.desafio_1.demo.services.mappers.UserFollowerMapper;
import com.desafio_1.demo.services.mappers.UserFollowedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public void addFollowUser(int userId, int userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed, UserNotFoundException {

        if(userId <= 0)
            throw new UserIdInvalidException();

        if(userIdToFollow <= 0)
            throw new UserIdInvalidException();

        if(userId == userIdToFollow)
            throw new UserIdFollowerEqualsFollowed();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        ArrayList<User> followed = userRepository.findFollowedByUserId(userId, createComparatorName(null));
        User userFollowed = followed.stream().filter(u -> u.getId() == userIdToFollow).findFirst().orElse(null);

        if(userFollowed == null)
            userRepository.addFollowUser(userId, userIdToFollow);

    }

    @Override
    public UserFollowerCountDTO findFollowersCount(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException {

        if(userId <= 0)
            throw new UserIdInvalidException();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        return UserFollowerCountMapper.toDTO(user, user.getFollowers().size());
    }

    @Override
    public UserFollowerDTO findFollowersByUserId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId <= 0)
            throw new UserIdInvalidException();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        ArrayList<User> followers = userRepository.findFollowersByUserId(userId, createComparatorName(order));

        return UserFollowerMapper.toDTO(user, followers);
    }

    @Override
    public UserFollowedDTO findFollowedByUserId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException {
        if(userId <= 0)
            throw new UserIdInvalidException();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        ArrayList<User> followed = userRepository.findFollowedByUserId(userId, createComparatorName(order));

        return UserFollowedMapper.toDTO(user, followed);
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) throws UserIdFollowerEqualsFollowed, UserIdInvalidException, UserNotFoundException, UnhandledException {
        if(userId <= 0)
            throw new UserIdInvalidException();

        if(userIdToUnfollow <= 0)
            throw new UserIdInvalidException();

        if(userId == userIdToUnfollow)
            throw new UserIdFollowerEqualsFollowed();

        User user = userRepository.findUserById(userId);

        if(user == null)
            throw new UserNotFoundException(userId);

        userRepository.unfollowUser(userId, userIdToUnfollow);
    }

    private Comparator<String> createComparatorName(String order){
        Comparator<String> comparator = (a, b) -> a.compareTo(b);

        if(order != null && order.equals("name_desc")){
            comparator = (a, b) -> b.compareTo(a);
        }
        return comparator;
    }
}
