package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PromoPostCountDTO extends UserDTO{
    private Integer promoproducts_count;

    public PromoPostCountDTO(UserDTO user) {
        this.setUserId(user.getUserId());
        this.setUserName(user.getUserName());
        this.promoproducts_count = 0;
    }

    public PromoPostCountDTO(){}
}
