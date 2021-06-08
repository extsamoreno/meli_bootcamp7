package com.example.demo.Services;


import com.example.demo.Exeptions.BadRequestExeption;
import com.example.demo.Exeptions.CustomExeption;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addFollow(int userId, int sellerId) throws CustomExeption {

        if(userRepository.getById(userId)==null){
            throw new BadRequestExeption("User not exist");
        }
        if(userRepository.getById(sellerId)==null){
            throw new BadRequestExeption("Seller not exist");
        }

        userRepository.getById(sellerId).getFollowers().add(userRepository.getById(userId));

    }

}
