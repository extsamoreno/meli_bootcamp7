package com.desafio.socialMeli.repository;

import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface IUserRepository {
    User getUserById(Integer id);
    UserDTO getUserDTOById(Integer id);
    Map<Integer, UserDTO> getOrCreateUserDTORepository();
    boolean updateUserDTORepository(UserDTO userDTO);
    List<User> getUserList();
    boolean repositoryStatus();
}
