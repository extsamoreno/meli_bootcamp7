package com.meli.desafio.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseUserListFollowers {
    private Integer id;
    private String userName;
    private List<UserDTO> followersList;
}
