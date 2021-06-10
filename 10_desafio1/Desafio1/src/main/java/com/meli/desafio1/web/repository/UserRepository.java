package com.meli.desafio1.web.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio1.web.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository


public class UserRepository implements IUserRepository{

    private List<User> UserList = loadDataUser();
        private List<User> loadDataUser() {
            File file = null;
            try{
                file = ResourceUtils.getFile("classpath:user.json");
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<User>> typeRef = new TypeReference<>() {};
            List<User> user = null;

            try {
                user = objectMapper.readValue(file,typeRef);
            } catch (IOException e){
                e.printStackTrace();
            }
            return user;

        }


    @Override
    public List<User> getUserList() {
        return this.UserList;
    }

    @Override
    public User getUserById(int userId) {
            for(User user: UserList){
                if(user.getUserId()==userId){
                    return user;
                }
            }
            return null;
    }
    @Override
    public String userNameByUserId(int userId) {
        for(User user:this.UserList){
            if(user.getUserId()==userId){
                return user.getUserName();
            }
        }
        return "";
    }
}
