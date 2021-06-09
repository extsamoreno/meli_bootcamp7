package com.api.socialmeli.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class FollowersCountDTO {
    private Integer userId;
    private String userName;
    private Integer followers_count;
}
