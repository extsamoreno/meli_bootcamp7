package com.socialmedia.socialmedia.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String nickname;
    private String password;
    private String name;
    private String surname;
    private String email;
    private int userType;
    private List<Follower> followers;
}
