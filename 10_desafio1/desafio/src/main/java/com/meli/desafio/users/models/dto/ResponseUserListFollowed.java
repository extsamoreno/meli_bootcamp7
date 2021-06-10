package com.meli.desafio.users.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class ResponseUserListFollowed {
    private Integer id;
    private String userName;
    private List<UserDTO> followed;
}
