package com.spring.desafioSpring.Models;

import lombok.*;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;
}
