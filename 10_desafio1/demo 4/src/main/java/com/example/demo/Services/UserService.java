package com.example.demo.Services;


import com.example.demo.Entities.User;
import com.example.demo.Exceptions.BadRequestException;
import com.example.demo.Exceptions.CustomException;
import com.example.demo.Exceptions.NotFoundException;
import com.example.demo.Repository.*;
import com.example.demo.Services.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public void addFollow(int userId, int sellerId) throws Exception {

        userRepository.loadUsers();
        User user = userRepository.getById(userId);
        User seller = userRepository.getById(sellerId);

        if(user==null){
            throw new NotFoundException("User not exist");
        }
        if(seller==null){
            throw new NotFoundException("Seller not exist");
        }

        if(seller.getFollowers().contains(user)){
            throw new BadRequestException("User already following this seller");
        }
        userRepository.getById(sellerId).getFollowers().add(userRepository.getById(userId));
        userRepository.saveUsers();

    }

    public ResponseCountFollowersDTO countFollowers (int sellerId) throws Exception{

        User user = userRepository.getById(sellerId);
        if(user == null){
            throw new NotFoundException("User not exists");
        }

        return new ResponseCountFollowersDTO(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().size()
        );
    }

    public ResponseListFollowersDTO listFollowers (int sellerId) throws Exception {

        User seller = userRepository.getById(sellerId);
        if(seller == null){
            throw new NotFoundException("User not exists");
        }

        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user : seller.getFollowers()){
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setUsername(user.getUserName());
            usersDTO.add(userDTO);
        }

        return new ResponseListFollowersDTO(
                seller.getUserId(),
                seller.getUserName(),
                usersDTO
        );
    }

    public ResponseListSellerDTO listSeller (int userId) throws Exception {
        User user = userRepository.getById(userId);
        List<User> seller =  userRepository.loadUsers();
        List<UserDTO> sellers = new ArrayList<>();

        if(seller == null){
            throw new NotFoundException("User not exists");
        }

        for(User userAux : seller){
            if(userAux.getFollowers().contains(user)){
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(userAux.getUserId());
                userDTO.setUsername(userAux.getUserName());
                sellers.add(userDTO);
            }
        }
        return new ResponseListSellerDTO(
                user.getUserId(),
                user.getUserName(),
                sellers
        );
    }

    public void unFolLowSeller(int idUser, int sellerId) throws Exception{

        User user = userRepository.getById(idUser);
        User seller = userRepository.getById(sellerId);

        if(user==null){
            throw new NotFoundException("User not exist");
        }
        if(seller==null){
            throw new NotFoundException("Seller not exist");
        }
        userRepository.unFollowSeller(user, seller);
        userRepository.saveUsers();
    }
}
