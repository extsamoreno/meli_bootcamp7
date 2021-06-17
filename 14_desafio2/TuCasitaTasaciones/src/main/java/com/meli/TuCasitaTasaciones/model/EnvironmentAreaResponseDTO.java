package com.meli.TuCasitaTasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentAreaResponseDTO {
    String EnvironmentName;
    double length;
    double width;
    double area;

}
