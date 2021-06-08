package com.meli.spring_challenge.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.spring_challenge.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FollowersCountDto extends User {
    private int followers_count;
}
