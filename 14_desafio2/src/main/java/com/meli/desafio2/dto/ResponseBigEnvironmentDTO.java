package com.meli.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBigEnvironmentDTO {

    private String name;
    private Double widthEnv;
    private Double lengthEnv;
}
