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

    public ArrayList<UserDTO> mapUserToDTOList (ArrayList<User> users) {
        return (ArrayList<UserDTO>) users.stream().map(user -> {
            try {
                return mapUserToDTO(user);
            } catch (UserIdNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    public UserDTO mapUserToDTO (User user) throws UserIdNotFoundException {
        return (new UserDTO(repository.findByUser(user), user.getUsername()));
    }

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

    public UserDTO mapSellertoUserDTO (Seller seller) throws UserIdNotFoundException {
        return (new UserDTO(repository.findByUser(seller), seller.getUsername()));
    }

    public List<User> mapObjectToUserList (List<Object> objects) {
        return objects.stream().map(object -> mapObjectToUser(object)).collect(Collectors.toList());
    }

    public User mapObjectToUser (Object object) {
        return ((User) object);
    }
}
