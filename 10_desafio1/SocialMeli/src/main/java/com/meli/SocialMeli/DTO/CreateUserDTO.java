package com.meli.SocialMeli.dto;

import com.meli.SocialMeli.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    private List<User> createDto;

}
