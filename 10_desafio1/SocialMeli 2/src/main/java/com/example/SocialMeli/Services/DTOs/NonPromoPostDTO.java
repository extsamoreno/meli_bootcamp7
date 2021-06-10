package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Getter @Setter @NoArgsConstructor
public class NonPromoPostDTO extends PostDTO{

    public NonPromoPostDTO(NonPromoPostDTO promoPostDTO){

        super(promoPostDTO);

    }
    public NonPromoPostDTO(int userId, int postId, String date, ProductDTO detail, String category, double price) throws DateTimeParseException {

        super(userId, postId, date,detail, category, price, false, 0.0);


    }




}
