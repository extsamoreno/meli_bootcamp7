package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.model.User;
import com.meli.socialmeli.service.dto.SellerDTO;
import com.meli.socialmeli.service.dto.UserBaseDTO;
import com.meli.socialmeli.service.dto.UserDTO;

import java.util.List;

public class UserMapper {

    public static UserBaseDTO modelToDBaseDTO(User model){
        return new UserBaseDTO(model.getUserId(), model.getUserName());
    }

    public static SellerDTO modelToSellerDTO(User model, List<UserBaseDTO> followers){
        return new SellerDTO(model.getUserId(), model.getUserName(), followers);
    }

    public static UserDTO modelToUserDTO(User model, List<UserBaseDTO> following){
        return new UserDTO(model.getUserId(), model.getUserName(), following);
    }

    public static User BaseDTOToModel(UserBaseDTO dto){
        return new User(null,dto.getUserName(),null);
    }

}
