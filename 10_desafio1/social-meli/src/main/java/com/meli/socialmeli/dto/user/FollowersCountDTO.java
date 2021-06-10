package com.meli.socialmeli.dto.user;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowersCountDTO {
    private Integer userId;
    private String userName;
    private Integer followersCount;
}
