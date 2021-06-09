package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Getter @Setter @NoArgsConstructor
public class PromoPostDTO extends PostDTO{

    private Boolean hasPromo;
    private double discount;

    public PromoPostDTO(PromoPostDTO promoPostDTO){

        super(promoPostDTO);
        this.setHasPromo(promoPostDTO.getHasPromo());
        this.setDiscount(promoPostDTO.getDiscount());

    }
    public PromoPostDTO(int userId, int postId, String date, ProductDTO detail, String category, double price, Boolean hasPromo, double discount) throws DateTimeParseException {

        super(userId, postId, date, detail, category, price);
        this.setHasPromo(hasPromo);
        this.setDiscount(discount);

    }



}
