package com.socialmeli.socialmeli.services.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmeli.socialmeli.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostPromoDTO {
    int userId;
    int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    Product detail;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    int category;
    double price;
    boolean hasPromo;
    double discount;
}
