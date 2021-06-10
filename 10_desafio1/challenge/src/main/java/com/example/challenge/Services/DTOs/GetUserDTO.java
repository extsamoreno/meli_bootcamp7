package com.example.challenge.Services.DTOs;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDTO {
    private int id;
    private String name;
    private List<UserDTO> followed;
    private List<UserDTO> followers;
    private List<PostPromotionDTO> posts;

}
