package com.desafio1.meli.service.DTO;

import com.desafio1.meli.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUnFollowUserToUser {
    private User user;          // User(user) follow to User(userFollow
    private User userUnFollower; // User(userFollower) to unfollow by User(user)
}
