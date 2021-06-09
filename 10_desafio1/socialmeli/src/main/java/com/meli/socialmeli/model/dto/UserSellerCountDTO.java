package com.meli.socialmeli.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSellerCountDTO {
    private int userId;
    private String userName;
    private int followersCount;
}
