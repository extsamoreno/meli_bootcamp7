package com.meli.spring_challenge.service.dto;

import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowDto extends User {
    private List<User> followerDtoList;
}
