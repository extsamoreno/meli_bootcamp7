package com.tucasitatasaciones.tucasitatasaciones.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipWithPriceDTO extends OwnershipDTO {
    private double price;

    public OwnershipWithPriceDTO(int i, String s, double v) {
        super(i, s);
        this.price = v;
    }
}
