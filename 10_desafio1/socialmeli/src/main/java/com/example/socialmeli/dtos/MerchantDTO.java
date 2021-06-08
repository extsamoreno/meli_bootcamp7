package com.example.socialmeli.dtos;

import com.example.socialmeli.models.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDTO {
    private Integer id;
    private String name;
    int followCount;
    List<User> users;
}
