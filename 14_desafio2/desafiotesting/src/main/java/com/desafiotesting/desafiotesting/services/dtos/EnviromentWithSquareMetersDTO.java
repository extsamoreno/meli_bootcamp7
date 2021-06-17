package com.desafiotesting.desafiotesting.services.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnviromentWithSquareMetersDTO {
    String name;
    double width;
    double length;
    double squareMeters;
}
