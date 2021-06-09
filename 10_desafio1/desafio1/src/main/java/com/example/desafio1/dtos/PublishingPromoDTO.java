package com.example.desafio1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishingPromoDTO extends PublishingDTO{
    private boolean hasPromo;
    private double discount;
}
