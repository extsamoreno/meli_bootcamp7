package com.meli.desafio.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserCountFollowers {
    private Integer id;
    private String userName;
    private Integer followersCount;
}
