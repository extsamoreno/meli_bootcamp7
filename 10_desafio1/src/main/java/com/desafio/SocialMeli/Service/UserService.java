package com.desafio.SocialMeli.Service;

import com.desafio.SocialMeli.Classes.User;
import com.desafio.SocialMeli.DTO.*;
import com.desafio.SocialMeli.Exception.User.UserExistsException;
import com.desafio.SocialMeli.Exception.User.UserFollowedByHimselfException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;
import com.desafio.SocialMeli.Repository.User.IUserRepository;
import com.desafio.SocialMeli.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iSocialMeliRepository;

    @Override
    public UserDTO createUser(String userName) throws UserExistsException {
        if (iSocialMeliRepository.getAllUsers().stream().anyMatch(user -> user.getUserName().equals(userName))) {
            throw new UserExistsException(userName);
        } else {
            User user = new User();
            user.setUserName(userName);
            iSocialMeliRepository.saveUser(user);
            return UserMapper.toDTO(user);
        }
    }

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserIdNotFoundException, UserFollowedByHimselfException {
        if (iSocialMeliRepository.getUserById(userId) != null) {
            if (iSocialMeliRepository.getUserById(userIdToFollow) != null) {
                if (userId != userIdToFollow) {
                    User user = iSocialMeliRepository.getUserById(userId);
                    User userToFollow = iSocialMeliRepository.getUserById(userIdToFollow);
                    user.setFollowed(userToFollow);
                    userToFollow.setFollowers(user);
                } else throw new UserFollowedByHimselfException(userId);
            } else throw new UserIdNotFoundException(userIdToFollow);
        } else  throw new UserIdNotFoundException(userId);
    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) throws UserIdNotFoundException {
        User user = iSocialMeliRepository.getUserById(userId);
        if (user != null) {
            return UserMapper.toFollowersCountDTO(user);
        } else throw new UserIdNotFoundException(userId);
    }

    @Override
    public FollowersListDTO getFollowersList(int userId) throws UserIdNotFoundException {
        User user = iSocialMeliRepository.getUserById(userId);
        if (user != null) {
            return UserMapper.toFollowersListDTO(user);
        } else throw new UserIdNotFoundException(userId);
    }

    @Override
    public FollowedListDTO getFollowedList(int userId) throws UserIdNotFoundException{
        User user = iSocialMeliRepository.getUserById(userId);
        if (user != null) {
            return UserMapper.toFollowedListDTO(user);
        } else throw new UserIdNotFoundException(userId);
    }
}