package com.meli.desafio2.dto.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePropTotalAreaDTO {

    private Integer id;
    private String name;
    private Double totalArea;
}
