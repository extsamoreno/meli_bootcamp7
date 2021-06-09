package com.example.demo.project.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
public class PublicationPromoDTO extends PublicationDTO{
    @NonNull
    private Boolean hasPromo;
    @NonNull
    private double discount;

    public PublicationPromoDTO(int id_post, int id_user, LocalDate date, ProductDTO detail, int category, double price, Boolean hasPromo, double discount) {
        super(id_post, id_user, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}

