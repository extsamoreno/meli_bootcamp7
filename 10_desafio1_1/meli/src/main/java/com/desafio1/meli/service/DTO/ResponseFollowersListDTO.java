package com.desafio1.meli.service.DTO;

import com.desafio1.meli.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.ListIterator;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFollowersListDTO {

    private  Integer userId;
    private String userName;
    private ArrayList<User> followers;

    public ResponseFollowersListDTO() {
        this.userId = -1;
        this.userName = "";
        this.followers = new ArrayList<>();
    }
}
