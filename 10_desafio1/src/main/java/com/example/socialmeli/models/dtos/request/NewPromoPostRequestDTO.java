package com.example.socialmeli.models.dtos.request;

import com.example.socialmeli.models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class NewPromoPostRequestDTO {
    private int userId;
    private int postId;
    @JsonFormat(pattern="dd-mm-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
