package com.desafiospring.socialMeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowersCountDTO {

    private Integer userId;
    private String userName;
    private Integer followers_count;

}

