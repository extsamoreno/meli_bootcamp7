package com.meli.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {

    private int userId;
    private String userName;
    //private String typeOfFollow;
}
