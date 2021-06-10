package com.socialMeli.mapper;

import com.socialMeli.exceptions.UserIdNotFoundException;
import com.socialMeli.models.DTOs.UserDTO;
import com.socialMeli.models.Seller;
import com.socialMeli.models.User;
import com.socialMeli.repository.iSocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SocialMeliMapper implements iSocialMeliMapper{

    @Autowired
    iSocialMeliRepository repository;

    /**
     * Map an ArrayList<Seller> into a ArrayList<UserDTO>
     * @param sellers
     * @return ArrayList<UserDTO>
     */
    public ArrayList<UserDTO> mapSellerToUserDTOList (ArrayList<Seller> sellers) {
        return (ArrayList<UserDTO>) sellers.stream().map(seller -> {
            try {
                return mapSellertoUserDTO(seller);
            } catch (UserIdNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    /**
     * Map a Seller into a UserDTO
     * @param seller
     * @return UserDTO --> int userId, string username
     * @throws UserIdNotFoundException
     */
    public UserDTO mapSellertoUserDTO (Seller seller) throws UserIdNotFoundException {
        return (new UserDTO(repository.findByUser(seller), seller.getUsername()));
    }
}
