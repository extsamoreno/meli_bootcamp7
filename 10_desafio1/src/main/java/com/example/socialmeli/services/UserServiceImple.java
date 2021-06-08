package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.ExistentFollowerException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowSellerResponseDTO;
import com.example.socialmeli.models.dtos.response.NewUserResponseDTO;
import com.example.socialmeli.exceptions.ExistentUserException;
import com.example.socialmeli.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public NewUserResponseDTO addUser(NewUserRequestDTO newUserRequestDTO) throws ExistentUserException {
        NewUserResponseDTO createdUser = new NewUserResponseDTO();
        UserDTO createdUserRespository = userRepository.addUser(newUserRequestDTO);

        createdUser.setUserId(createdUserRespository.getUserId());
        createdUser.setUserName(createdUserRespository.getUserName());

        return createdUser;
    }

    @Override
    public FollowSellerResponseDTO followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException {
        FollowSellerResponseDTO modifiedUser = userRepository.followSeller(userId, userIdToFollow);

        return modifiedUser;
    }
}
