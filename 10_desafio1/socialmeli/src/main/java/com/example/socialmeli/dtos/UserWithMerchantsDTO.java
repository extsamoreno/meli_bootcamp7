package com.example.socialmeli.dtos;

import com.example.socialmeli.models.Merchant;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithMerchantsDTO {
    Integer id;
    String name;
    List<Merchant> merchants;
}
