package com.example.desafio1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Following {
    private int userIdFollowed;
    private int userIdFollower;

    public boolean equals(Following a){
        return a.getUserIdFollower() == this.userIdFollower && a.getUserIdFollowed() == this.userIdFollowed;
    }
}
