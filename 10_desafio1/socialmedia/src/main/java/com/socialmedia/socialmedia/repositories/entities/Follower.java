package com.socialmedia.socialmedia.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Follower {
    private int id;
    private int userId;
    private int followerId;
}
