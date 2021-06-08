package com.meli.socialmeli.model.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSellerListDTO {
    private int userId;
    private String userName;
    private ArrayList<UserSimpleDTO> followers = new ArrayList<>();
}
