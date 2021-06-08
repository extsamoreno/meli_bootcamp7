package com.socialMeli.user;

import com.socialMeli.user.exceptions.UserIdNotFoundException;
import com.socialMeli.user.models.Seller;
import com.socialMeli.user.models.User;
import com.socialMeli.user.models.UserDTO;
import com.socialMeli.user.repository.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObjectMapper {

    @Autowired
    iUserRepository repository;

    public ArrayList<UserDTO> mapUserList (ArrayList<User> users) {
        return (ArrayList<UserDTO>) users.stream().map(user -> {
            try {
                return mapUser(user);
            } catch (UserIdNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    public UserDTO mapUser (User user) throws UserIdNotFoundException {
        return (new UserDTO(repository.findByUser(user), user.getUsername()));
    }

    public ArrayList<UserDTO> mapSellerList (ArrayList<Seller> sellers) {
        return (ArrayList<UserDTO>) sellers.stream().map(seller -> {
            try {
                return mapSeller(seller);
            } catch (UserIdNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    public UserDTO mapSeller (Seller seller) throws UserIdNotFoundException {
        return (new UserDTO(repository.findByUser(seller), seller.getUsername()));
    }
}
