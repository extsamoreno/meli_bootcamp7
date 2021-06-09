package com.meli.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Follow {
    private int id;
    private int followerId;
    private int followedId;
    private boolean active;

    public Follow(int id, int followerId, int followedId) {
        this.id = id;
        this.followerId = followerId;
        this.followedId = followedId;
        active=true;
    }
}
