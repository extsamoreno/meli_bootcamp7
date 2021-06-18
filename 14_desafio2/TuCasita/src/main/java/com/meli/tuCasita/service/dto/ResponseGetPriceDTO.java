package com.meli.tuCasita.service.dto;

import com.meli.tuCasita.model.House;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ResponseGetPriceDTO {
    private House house;
    private Double price;
}
