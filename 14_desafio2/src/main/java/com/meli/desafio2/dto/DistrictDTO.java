package com.meli.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    private Integer id;
    private String name;
    private Double price;

}
