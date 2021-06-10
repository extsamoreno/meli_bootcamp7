package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PromoPostListDTO extends UserDTO{

    private List<PromoPostDTO> listPromo;

    public PromoPostListDTO (UserDTO user){
        this.setUserId(user.getUserId());
        this.setUserName(user.getUserName());
        this.listPromo = new ArrayList<>();
    }
}
