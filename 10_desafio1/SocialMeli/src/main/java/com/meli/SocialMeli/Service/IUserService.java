package com.meli.SocialMeli.Service;

import com.meli.SocialMeli.DTO.CreateUserDTO;
import com.meli.SocialMeli.DTO.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> newUser(CreateUserDTO createUserDTO);

    boolean followSeller(int userId, int userIdToFollow);
}
