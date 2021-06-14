package com.desafio.socialMeli.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDTOCount {
    private Integer userId;
    private String userName;
    private Integer promoCount;

    public PostDTOCount(Integer id, String name, Integer promoCount) {
        this.userId = id;
        this.userName = name;
        this.promoCount = promoCount;
    }
}
