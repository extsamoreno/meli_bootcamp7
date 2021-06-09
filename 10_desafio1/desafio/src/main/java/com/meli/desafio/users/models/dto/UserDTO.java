package com.meli.desafio.users.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO implements Comparable<UserDTO>{
    private Integer id;
    private String userName;

    @Override
    public int compareTo(UserDTO o) {
        return this.userName.compareToIgnoreCase(o.getUserName());
    }
}
