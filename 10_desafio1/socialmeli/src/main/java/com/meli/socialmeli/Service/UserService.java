package com.meli.socialmeli.Service;

import com.meli.socialmeli.dto.UserFollowerDTO;
import com.meli.socialmeli.dto.UserResponseCountDTO;
import com.meli.socialmeli.exception.UserInvalidException;
import com.meli.socialmeli.model.UserMeli;
import com.meli.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void follow(int userId, int userIdToFollow) throws UserInvalidException {
        System.out.println("userId = " + userId);
        System.out.println("userIdToFollow = " + userIdToFollow);
        if (userId != userIdToFollow) {
            iUserRepository.follow(userId, userIdToFollow);
        } else {
            throw new UserInvalidException();
        }
    }

    @Override
    public UserFollowerDTO getFollowersList(int userId) {

        return iUserRepository.ListUser(userId);
    }

    @Override
    public UserResponseCountDTO getFollowers(int userId) {
        //UserResponseDTO userResponseDTO = new UserResponseDTO(userId, ,iUserRepository.getFollowersById(userId));
        return iUserRepository.getFollowersById(userId);
    }
}
