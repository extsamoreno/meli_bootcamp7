package com.example.socialmeli.dtos.user;

import com.example.socialmeli.dtos.user.SimpleMerchantDTO;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedByMeListDTO {
    private Integer id;
    private String name;
    List<SimpleMerchantDTO> followers;
}
