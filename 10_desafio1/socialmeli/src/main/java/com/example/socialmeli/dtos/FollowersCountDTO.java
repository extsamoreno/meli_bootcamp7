package com.example.socialmeli.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowersCountDTO {
    private String name;
    private Integer id, count;
}
