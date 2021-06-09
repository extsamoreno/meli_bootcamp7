package com.desafio1.meli.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseCountFollower {
    private Integer userId;
    private String userName;
    private Integer followers_count;
    private boolean sucessfull;

    public ResponseCountFollower() {
        this.userId = -1;
        this.userName = "";
        this.followers_count = 0;
        this.sucessfull = false;
    }

}
