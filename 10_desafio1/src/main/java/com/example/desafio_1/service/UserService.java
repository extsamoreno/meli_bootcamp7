package com.example.desafio_1.service;

import com.example.desafio_1.exception.UserExceptionAlreadyFollowed;
import com.example.desafio_1.exception.UserExceptionNotFound;
import com.example.desafio_1.exception.UserExceptionWrongType;
import com.example.desafio_1.models.Buyer;
import com.example.desafio_1.models.Seller;
import com.example.desafio_1.models.User;
import com.example.desafio_1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserExceptionNotFound, UserExceptionWrongType, UserExceptionAlreadyFollowed {
        //QUe existe que va a seguir

        User userFollower = getUserById(userId);
        User userToFollow = getUserById(userIdToFollow);

        //The following user exists in the "database"
        if (userFollower == null) {
            throw new UserExceptionNotFound(userId);
        }
        //The user that want to follow exists in the "database"
        if (userToFollow == null) {
            throw new UserExceptionNotFound(userIdToFollow);
        }

        //Check instances
        if(!(userFollower instanceof Buyer)) {
            throw new UserExceptionWrongType(userId, "Buyer");
        }

        if(!(userToFollow instanceof Seller)) {
            throw new UserExceptionWrongType(userIdToFollow, "Seller");
        }

        //Validate that the user is not in the list
        if(((Buyer) userFollower).getFollowing().get(userIdToFollow) != null) {
            throw new UserExceptionAlreadyFollowed(userId, userIdToFollow);
        }

        userRepository.followUser((Buyer) userFollower, (Seller) userToFollow);
    }


    public boolean existsUser(int userId) {
        return userRepository.getById(userId) == null;
    }

    public User getUserById(int userId) {
        return userRepository.getById(userId);
    }

}
