package com.example.demo.repositories;

import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IUserRepository {

    User getUserById(Integer id);


}
