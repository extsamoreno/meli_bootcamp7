package com.meli.tuCasita.service.dto;

import com.meli.tuCasita.model.House;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseMeter2DTO {
    private House house;
    private Double meter2;
}
