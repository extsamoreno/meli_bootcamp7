package com.Desafio1.SocialMeli.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Comparable<UserDTO>{
    private int userId;
    private String userName;

    @Override
    public int compareTo(UserDTO user) {
        return this.userName.compareTo(user.getUserName());
    }
}
