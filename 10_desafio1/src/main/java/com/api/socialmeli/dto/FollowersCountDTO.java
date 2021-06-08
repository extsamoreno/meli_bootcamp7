package com.api.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class FollowersCountDTO {
    private Integer userId;
    private String userName;
    private Integer followers_count;
}
