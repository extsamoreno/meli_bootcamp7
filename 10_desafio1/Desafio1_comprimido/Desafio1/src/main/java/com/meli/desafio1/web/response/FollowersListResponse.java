package com.meli.desafio1.web.response;

import com.meli.desafio1.web.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersListResponse {
    private int userId;
    private String userName;
    private List<UserDTO> followers;
}
