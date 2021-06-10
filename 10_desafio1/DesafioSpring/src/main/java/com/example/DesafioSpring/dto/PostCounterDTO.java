package com.example.DesafioSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCounterDTO extends UserDTO {
    private int productsWithPromo;

    public PostCounterDTO(int userId, String userName, int postCounter){

        this.setUserId(userId);
        this.setUserName(userName);
        this.setProductsWithPromo(postCounter);
    }
}
