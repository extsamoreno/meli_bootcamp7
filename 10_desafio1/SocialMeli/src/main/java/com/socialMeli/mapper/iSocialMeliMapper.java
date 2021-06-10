package com.socialMeli.mapper;

import com.socialMeli.exceptions.UserIdNotFoundException;
import com.socialMeli.models.DTOs.UserDTO;
import com.socialMeli.models.Seller;
import com.socialMeli.models.User;

import java.util.ArrayList;
import java.util.List;

public interface iSocialMeliMapper {

    ArrayList<UserDTO> mapSellerToUserDTOList (ArrayList<Seller> sellers);
    UserDTO mapSellertoUserDTO (Seller seller) throws UserIdNotFoundException;
}
