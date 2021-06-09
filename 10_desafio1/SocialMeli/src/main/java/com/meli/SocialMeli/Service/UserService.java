package com.meli.SocialMeli.Service;

import org.springframework.stereotype.Service;
import com.meli.SocialMeli.DTO.CreateUserDTO;
import com.meli.SocialMeli.DTO.UserDTO;
import com.meli.SocialMeli.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    IUserRepository iUserRepository;

    // Inyeccion de dependencia por constructor
    public UserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }

    @Override
    public List<UserDTO> newUser(CreateUserDTO createUserDTO) {
        return iUserRepository.createUser(createUserDTO);
    }

    @Override
    public boolean followSeller(int userId, int userIdToFollow) {
        return iUserRepository.followSeller(userId, userIdToFollow);
    }
}
