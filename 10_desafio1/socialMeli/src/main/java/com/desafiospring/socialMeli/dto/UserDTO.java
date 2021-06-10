package com.desafiospring.socialMeli.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private int userId;
    private String userName;

    public UserDTO(int userId, String userName) {
    }
}
