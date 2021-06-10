package com.desafio1.meli.service.DTO;

import com.desafio1.meli.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestFollowUserToUser {
    private User user;          // User(user) follow to User(userFollow
    private User userFollower; // User(userFollower) to follow by User(user)
}
