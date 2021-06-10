package com.example.desafiospring.socialmeli.service.mapper;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Seller;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.repository.IUserRepository;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.service.DTO.UserFollowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements IUserMapper{

    @Autowired
    IUserRepository repository;

    public static UserFollowDTO getUserFollowDTO(User user1) {
    }

    /**
     * Map an ArrayList<Seller> into a ArrayList<UserDTO>
     */
    public ArrayList<UserDTO> mapSellerToUserDTOList (ArrayList<Seller> sellers) {
        return (ArrayList<UserDTO>) sellers.stream().map(seller -> {
            try {
                return mapSellertoUserDTO(seller);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    /**
     * Map a Seller into a UserDTO
     */
    public UserDTO mapSellertoUserDTO (Seller seller) throws UserNotFoundException {
        return (new UserDTO(repository.findBy(seller), seller.getUsername()));
    }
}