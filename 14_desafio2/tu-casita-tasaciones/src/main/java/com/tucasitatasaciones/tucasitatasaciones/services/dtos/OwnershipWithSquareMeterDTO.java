package com.tucasitatasaciones.tucasitatasaciones.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipWithSquareMeterDTO extends OwnershipDTO {
    private double squareMeter;
}
