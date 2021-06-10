package com.example.demo.project.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
public class PublicationPromoDTO extends PublicationDTO{
    @NotNull(message="El 'has_promo' es un campo requerido.")
    private Boolean has_promo;
    @NotNull(message="El 'discount' es un campo requerido.")
    private Double discount;

    public PublicationPromoDTO(int post_id, int user_id, LocalDate date, ProductDTO detail, int category, double price, Boolean has_promo, double discount) {
        super(post_id, user_id, date, detail, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}

