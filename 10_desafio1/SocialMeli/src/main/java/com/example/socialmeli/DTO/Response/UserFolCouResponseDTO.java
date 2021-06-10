package com.example.socialmeli.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFolCouResponseDTO {
    private int userId;
    private String userName;
    private int followersCount;
}
