package com.meli.desafio.users.models;

import com.meli.desafio.users.models.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User  {
    private Integer id;
    private String userName;
    private List<UserDTO> followed;
}
