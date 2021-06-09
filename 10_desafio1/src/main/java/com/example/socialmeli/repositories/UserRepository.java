package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.ExistentFollowerException;
import com.example.socialmeli.exceptions.ExistentUserException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.User;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowSellerResponseDTO;
import com.example.socialmeli.models.dtos.response.FollowersCountResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    UserDTO addUser(NewUserRequestDTO newUser) throws ExistentUserException;
    FollowSellerResponseDTO followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException;
    User getUserById (int userId) throws InexistentUserException;
    List<UserDTO> getUsers();
    FollowersCountResponseDTO countResponse(int userId) throws InexistentUserException;
}
