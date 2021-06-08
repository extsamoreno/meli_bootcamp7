package com.example.SocialMeli.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public abstract class Followment {

    private String userId;
    private String userName;
}
