package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.repository.IUserRepository;
import com.example.MeliSocialApi.project.service.dto.FollowedUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserFollowersCountDTOResponse;
import com.example.MeliSocialApi.project.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    public boolean follow(Integer idUser, Integer idUserToFollow) throws UserNotFoundException{
        User user = userRepository.getUser(idUser);
        User userToFollow = userRepository.getUser(idUserToFollow);
        if(userRepository.follow(user,userToFollow)) {
            return true;
        }
        else if(user==null)
            throw new UserNotFoundException(idUser);
        throw new UserNotFoundException(idUserToFollow);
    }

    @Override
    public UserFollowersCountDTOResponse getFollowersCount(Integer idUser) throws UserNotFoundException {
        User user = userRepository.getUser(idUser);
        if(user==null)
            throw new UserNotFoundException(idUser);
        return UserMapper.userToUserFollowersCountDTO(user);
    }

    @Override
    public FollowersUserDTOResponse getFollowersList(Integer idUser) throws UserNotFoundException {
        User user = userRepository.getUser(idUser);
        if(user==null)
            throw new UserNotFoundException(idUser);
        LinkedHashSet<Integer> followers = user.getFollowers();
        LinkedHashSet<User> followersUser = new LinkedHashSet<User>();
        for(Integer follower : followers){
            followersUser.add(userRepository.getUser(follower));
        }
        return UserMapper.userToFollowersUserDTO(user,followersUser);
    }
/*
    @Override
    public FollowedUserDTOResponse getFollowedList(Integer idUser) throws UserNotFoundException {
        User user = userRepository.getUser(idUser);
        if(user==null)
            throw new UserNotFoundException(idUser);
        LinkedHashSet<Integer> followers = user.getFollowers();

        return UserMapper.userToFollowersUserDTO(user,followersUser);
    }
    */
}
