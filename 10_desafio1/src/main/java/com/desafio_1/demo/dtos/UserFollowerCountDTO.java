package com.desafio_1.demo.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowerCountDTO extends UserResponseDTO{
    @JsonProperty("followers_count")
    private int followersCount;

    public UserFollowerCountDTO(int id, String userName, int followersCount) {
        super(id, userName);
        this.followersCount = followersCount;
    }
}
