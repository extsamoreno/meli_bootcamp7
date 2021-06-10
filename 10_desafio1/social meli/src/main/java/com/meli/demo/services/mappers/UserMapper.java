package com.meli.demo.services.mappers;

import com.meli.demo.dtos.SellerDTO;
import com.meli.demo.dtos.UserDTO;
import com.meli.demo.models.Seller;
import com.meli.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserMapper {

    public static UserDTO toDTO(User user){
        return new UserDTO(user.getUserId(),
                user.getUserName());
    }

    public static User toSeller(UserDTO user){
        return new User(user.getUserId(),
                user.getUserName());
    }
}
