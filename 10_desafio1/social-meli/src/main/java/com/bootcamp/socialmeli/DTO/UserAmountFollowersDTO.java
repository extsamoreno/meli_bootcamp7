package com.bootcamp.socialmeli.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAmountFollowersDTO {
    private int userId;
    private String userName;
    private Integer followersCount;
}
