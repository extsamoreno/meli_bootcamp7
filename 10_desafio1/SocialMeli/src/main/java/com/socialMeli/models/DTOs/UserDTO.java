package com.socialMeli.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Comparable<UserDTO> {

    private Integer userId;
    private String username;


    //0 si son iguales, <0 si username va antes de o.username, >0 al reves
    @Override
    public int compareTo(UserDTO o) {
        return (this.username.compareTo(o.username));
    }
}
