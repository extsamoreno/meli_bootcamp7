package com.meli.socialmeli.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowersCountDTO {
    private Integer userId;
    private String username;
    private Integer followers_count;
}
