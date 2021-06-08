package com.desafio.socialMeli.service;


import com.desafio.socialMeli.service.dto.UserDTO;


public interface IUserService {

    String followById(Integer userId, Integer userIdToFollow);
    String loadDatabaseDTO();
}

