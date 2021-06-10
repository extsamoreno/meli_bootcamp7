package com.example.desafiospring.socialmeli.service.mapper;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Seller;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;

import java.util.ArrayList;

public interface IUserMapper {
    ArrayList<UserDTO> mapSellerToUserDTOList (ArrayList<Seller> sellers);
    UserDTO mapSellertoUserDTO (Seller seller) throws UserNotFoundException;
}
