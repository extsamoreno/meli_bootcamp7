package com.meli.socialmeli.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Map;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserModel {
    private String username;
    Map<Integer, UserModel> followedBy;
    Map<Integer, UserModel> followers;

}
