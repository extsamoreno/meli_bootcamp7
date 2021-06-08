package com.example.socialmeli.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String name;
    Merchant[] merchants;
}
