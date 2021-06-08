package com.meli.socialmeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOFollowedList {
    private int userId;
    private String userName;
    private List<UserDTOSimpleUser> followed;
}
