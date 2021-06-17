package com.meli.TuCasitaTasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {
    String district;
    List<EnvironmentDTO> environments;
}
