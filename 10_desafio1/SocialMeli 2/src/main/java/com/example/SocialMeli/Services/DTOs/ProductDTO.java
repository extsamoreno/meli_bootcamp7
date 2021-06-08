package com.example.SocialMeli.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProductDTO {

    private int id;
    private String name;
    private String type;
    private String color;
    private String notes;

}
