package com.meli.socialmeli.model.dto;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSellerListPromoDTO {
    private int userId;
    private String userName;
    private ArrayList<PostPromoDTO> post = new ArrayList<>();
}
