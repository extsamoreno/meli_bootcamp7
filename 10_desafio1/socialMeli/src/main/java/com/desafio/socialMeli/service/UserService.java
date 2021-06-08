package com.desafio.socialMeli.service;

import com.desafio.socialMeli.repository.IUserRepository;
import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.UserDTO;
import com.desafio.socialMeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public String loadDatabaseDTO(){

        iUserRepository.getOrCreateUserDTORepository();

        for(User user: iUserRepository.getUserList()) {
            UserDTO userDTOtoLoad = UserMapper.toDTO(user);
            iUserRepository.updateUserDTORepositoy(userDTOtoLoad);
        }
        return "ok";
    }

    @Override
    public String followById(Integer userId, Integer userIdToFollow){

        UserDTO userDTOtoFollow = iUserRepository.getUserDTOById(userIdToFollow);

        userDTOtoFollow.addFollower(iUserRepository.getUserById(userId));

        iUserRepository.updateUserDTORepositoy(userDTOtoFollow);

        return ("el usuario " + userId + "ahora sigue a " + userDTOtoFollow.getName());
    }

}

