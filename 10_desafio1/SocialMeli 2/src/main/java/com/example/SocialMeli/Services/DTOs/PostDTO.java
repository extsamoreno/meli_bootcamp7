package com.example.SocialMeli.Services.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PostDTO{

    private int userId;
    private int postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private String category;
    private double price;
    private Boolean hasPromo;
    private double discount;


}
