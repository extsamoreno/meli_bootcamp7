package com.desafio1.meli.service.DTO;

import com.desafio1.meli.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFollowsListDTO {

    private  Integer userId;
    private String userName;
    private ArrayList<User> follow;

    public ResponseFollowsListDTO() {
        this.userId = -1;
        this.userName = "";
        this.follow = new ArrayList<>();
    }
}
