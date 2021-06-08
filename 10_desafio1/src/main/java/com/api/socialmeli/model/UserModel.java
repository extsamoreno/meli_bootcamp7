package com.api.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashMap;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserModel {
    private String userName;
    private HashMap<Integer,String> followers;
}



