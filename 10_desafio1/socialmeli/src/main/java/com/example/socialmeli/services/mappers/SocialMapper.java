package com.example.socialmeli.services.mappers;

import com.example.socialmeli.dtos.user.MerchantDTO;
import com.example.socialmeli.dtos.user.SimpleMerchantDTO;
import com.example.socialmeli.dtos.user.UserDTO;
import com.example.socialmeli.models.Merchant;
import com.example.socialmeli.models.User;

public class SocialMapper {

    public static User userDTOtoModel(UserDTO userDTO){
        User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());

        return user;
    }

    public static Merchant merchantDTOtoModel(MerchantDTO merchantDTO){
        Merchant merchant = new Merchant();

        merchant.setName(merchantDTO.getName());
        merchant.setUsers(merchantDTO.getUsers().toArray(new User[0]));
        merchant.setId(merchantDTO.getId());
        merchant.setFollowCount(merchantDTO.getFollowCount());

        return merchant;
    }

    public static SimpleMerchantDTO merchantDTOtoSimpleDTO(MerchantDTO merchantDTO){
        SimpleMerchantDTO simple = new SimpleMerchantDTO();

        simple.setId(merchantDTO.getId());
        simple.setName(merchantDTO.getName());

        return simple;
    }
}
