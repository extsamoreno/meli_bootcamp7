package com.example.socialmeli.dtos;

import com.example.socialmeli.models.Merchant;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedByMeListDTO {
    private Integer id;
    private String name;
    List<Merchant> followers;
}
