package com.example.desafio2.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePropertyValueDTO {
    private String propertyName;
    private double valueOfProperty;
}
