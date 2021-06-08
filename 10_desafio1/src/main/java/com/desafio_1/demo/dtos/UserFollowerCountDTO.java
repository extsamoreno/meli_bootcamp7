package com.desafio_1.demo.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowerCountDTO {
    private Integer id;
    private String userName;
    @JsonProperty("followers_count")
    private Integer followersCount;
}
