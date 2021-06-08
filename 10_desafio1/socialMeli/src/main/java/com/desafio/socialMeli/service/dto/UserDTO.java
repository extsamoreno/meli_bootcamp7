package com.desafio.socialMeli.service.dto;

import com.desafio.socialMeli.repository.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private String name;
    private List<User> users;

    public UserDTO() {
        this.name = "";
        this.users = new ArrayList<User>();
    }


    public void addFollower(User user) {
        this.users.add(user);
    }
}
