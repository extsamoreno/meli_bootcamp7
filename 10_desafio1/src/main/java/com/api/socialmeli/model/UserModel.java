package com.api.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserModel {
    private int userId;
    private String userName;
    private ArrayList<UserModel> followers;
    private ArrayList<UserModel> followed;
}



