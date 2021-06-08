package com.meli.desafio.models;

import com.meli.desafio.models.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private List<UserDTO> followed;
}
