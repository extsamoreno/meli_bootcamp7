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
    public int id;
    public String nickname;
    public String password;
    public String name;
    public String surname;
    public String email;
    public int userType;
    public List<Follower> followers;
}
