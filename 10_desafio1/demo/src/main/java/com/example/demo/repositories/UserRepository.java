package com.example.demo.repositories;

import com.example.demo.database.DataBase;
import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
@Data
public class UserRepository implements IUserRepository {

    private HashMap<Integer, UserDTO> map = new HashMap<>();
    private ArrayList<User> dataBaseUsers = DataBase.dataBaseUsers;

    @Override
    public User getUserById(Integer id) {
        for (User user: dataBaseUsers) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

}
