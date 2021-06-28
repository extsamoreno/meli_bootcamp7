package com.Desafio1.SocialMeli.DTOS;

import com.Desafio1.SocialMeli.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    List<User> userList = new ArrayList<>();
}
