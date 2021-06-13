package com.desafio.socialMeli.model.dao.repository;

import com.desafio.socialMeli.model.dao.models.User;
import com.desafio.socialMeli.model.dto.PostDTO;

import java.util.HashMap;
import java.util.List;

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
