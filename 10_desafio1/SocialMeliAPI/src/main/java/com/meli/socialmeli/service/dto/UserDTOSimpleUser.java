package com.meli.socialmeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOSimpleUser {
    private int userId;
    private String userName;
}
