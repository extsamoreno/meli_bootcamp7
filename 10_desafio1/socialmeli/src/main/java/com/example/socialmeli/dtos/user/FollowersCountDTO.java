package com.example.socialmeli.dtos.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowersCountDTO {
    private String name;
    private Integer id, count;
}
