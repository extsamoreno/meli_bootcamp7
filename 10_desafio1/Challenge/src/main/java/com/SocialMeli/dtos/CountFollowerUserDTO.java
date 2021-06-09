package com.SocialMeli.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

class CountFollowerUserDTO extends UserResponseDTO{
    @JsonProperty("followers_count")
    private Integer followersCount;

    public CountFollowerUserDTO(Integer id, String userName, Integer followersCount) {
        super(id, userName);
        this.followersCount = followersCount;
    }
}
