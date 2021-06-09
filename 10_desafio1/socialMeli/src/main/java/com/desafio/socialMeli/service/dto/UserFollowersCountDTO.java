package com.desafio.socialMeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersCountDTO {
    private Integer userId;
    private String userName;
    private Integer followers_count;
}
