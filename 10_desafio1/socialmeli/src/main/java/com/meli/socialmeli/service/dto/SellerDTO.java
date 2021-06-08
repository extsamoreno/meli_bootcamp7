package com.meli.socialmeli.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SellerDTO extends UserBaseDTO{

    private List<UserBaseDTO> followers;

    public SellerDTO(Integer userId, String userName, List<UserBaseDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
