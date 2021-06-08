package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.ExistentFollowerException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowSellerResponseDTO;
import com.example.socialmeli.models.dtos.response.NewUserResponseDTO;
import com.example.socialmeli.exceptions.ExistentUserException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    NewUserResponseDTO addUser(NewUserRequestDTO newUserRequestDTO) throws ExistentUserException;
    FollowSellerResponseDTO followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException;
}
