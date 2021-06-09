package com.meli.SocialMeli.Repository;
import com.meli.SocialMeli.DTO.CreateUserDTO;
import com.meli.SocialMeli.DTO.UserDTO;

import java.util.List;

public interface IUserRepository {
    UserDTO searchUserById(int userId);

    boolean followSeller(int userId, int userIdToFollow);

    List<UserDTO> createUser(CreateUserDTO createUserDTO);
}
