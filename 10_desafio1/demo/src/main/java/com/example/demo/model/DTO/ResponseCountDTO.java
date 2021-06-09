package com.example.demo.model.DTO;

import com.example.demo.model.User;
import lombok.Data;

@Data
public class ResponseCountDTO {

    private int id;
    private String userName;
    private int followersCount;

    public ResponseCountDTO(String userName, int id, int followersCount) {
        this.userName = userName;
        this.id = id;
        this.followersCount = followersCount;
    }
}
