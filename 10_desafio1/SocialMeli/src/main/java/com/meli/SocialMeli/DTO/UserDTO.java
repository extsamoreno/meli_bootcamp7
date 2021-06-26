package com.meli.SocialMeli.dto;

import com.meli.SocialMeli.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int idUserDto;
    private String userNameDto;
}
