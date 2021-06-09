package com.example.socialmeli.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {
    private String name;
    private Integer Id, followCount;
    private User[] users;
}
