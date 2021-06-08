package com.example.desafio_1.service;

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
    public void followUser(int userId, int userIdToFollow) throws UserExceptionNotFound, UserExceptionWrongType {
        //QUe existe que va a seguir

        User userFollower = getUserById(userId);
        User userToFollow = getUserById(userIdToFollow);

        if (userFollower == null) {
            throw new UserExceptionNotFound(userId);
        }
        //Que exista el usuario que quiere seguir
        if (userToFollow == null) {
            throw new UserExceptionNotFound(userIdToFollow);
        }

        if(!(userFollower instanceof Buyer)) {
            throw new UserExceptionWrongType(userId, "Buyer");
        }

        if(!(userToFollow instanceof Seller)) {
            throw new UserExceptionWrongType(userIdToFollow, "Seller");
        } //Validate that the user is not in the list

        userRepository.followUser((Buyer) userFollower, (Seller) userToFollow);
    }


    public boolean existsUser(int userId) {
        return userRepository.getById(userId) == null;
    }

    public User getUserById(int userId) {
        return userRepository.getById(userId);
    }

}
