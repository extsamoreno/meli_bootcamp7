package com.desafio.socialMeli.repository;

import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.PostDTO;
import com.desafio.socialMeli.service.dto.UserDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ISocialMeliRepository {
    User getUserById(Integer id);
    List<User> getUserList();
    List<PostDTO>getPostDTOListByUserId(Integer userid);

    <T> T getDTOById(Integer id, Integer table);
    <T> HashMap<Integer, T> getOrCreateDTOTable(Integer table);
    <T> boolean updateDTORepository(T t);
    public <T> Integer indexOfDTOinRepository(T t);
    boolean tableInRepositoryStatus(Integer table);

}
